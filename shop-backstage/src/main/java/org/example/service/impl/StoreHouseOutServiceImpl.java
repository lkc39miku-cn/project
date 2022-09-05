package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.Commodity;
import org.example.entity.StoreHouse;
import org.example.entity.StoreHouseOut;
import org.example.entity.convert.StoreHouseOutConvert;
import org.example.entity.param.StoreHouseOutParam;
import org.example.mapper.CommodityMapper;
import org.example.mapper.StoreHouseMapper;
import org.example.mapper.StoreHouseOutMapper;
import org.example.result.ServiceExecute;
import org.example.service.StoreHouseOutService;
import org.example.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreHouseOutServiceImpl implements StoreHouseOutService {
    @Autowired
    private StoreHouseOutMapper storeHouseOutMapper;
    @Autowired
    private StoreHouseOutConvert storeHouseOutConvert;
    @Autowired
    private StoreHouseMapper storeHouseMapper;
    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public IPage<StoreHouseOut> selectListByPage(StoreHouseOutParam storeHouseOutParam) {
        return storeHouseOutMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), null);
    }

    @Override
    public int insert(StoreHouseOut storeHouseOut) {
        ServiceExecute.compare(storeHouseOutMapper.insert(storeHouseOut), ServiceExecute.ExecuteStatus.INSERT);

        StoreHouse storeHouse = storeHouseMapper.selectOne(new LambdaQueryWrapper<StoreHouse>()
                .eq(StoreHouse::getId, storeHouseOut.getStoreHouseId()));

        ServiceExecute.compare(storeHouseMapper.updateById(storeHouse.setStock(
                storeHouse.getStock() - storeHouseOut.getRealOutNumber())), ServiceExecute.ExecuteStatus.UPDATE);

        Commodity commodity = commodityMapper.selectById(storeHouse.getCommodityId());
        return commodityMapper.updateById(commodity.setCommodityNumber(commodity.getCommodityNumber() + storeHouseOut.getRealOutNumber()));
    }

    @Override
    public int update(StoreHouseOut storeHouseOut) {
        return storeHouseOutMapper.updateById(storeHouseOut);
    }

    @Override
    public int delete(String id) {
        return storeHouseOutMapper.deleteById(id);
    }
}
