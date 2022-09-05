package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.StoreHouse;
import org.example.entity.StoreHouseIn;
import org.example.entity.convert.StoreHouseInConvert;
import org.example.entity.param.StoreHouseInParam;
import org.example.mapper.StoreHouseInMapper;
import org.example.mapper.StoreHouseMapper;
import org.example.result.ServiceExecute;
import org.example.service.StoreHouseInService;
import org.example.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreHouseInServiceImpl implements StoreHouseInService {
    @Autowired
    private StoreHouseInMapper storeHouseInMapper;
    @Autowired
    private StoreHouseInConvert storeHouseInConvert;
    @Autowired
    private StoreHouseMapper storeHouseMapper;

    @Override
    public IPage<StoreHouseIn> selectListByPage(StoreHouseInParam storeHouseInParam) {
        return storeHouseInMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), null);
    }

    @Override
    public int insert(StoreHouseIn storeHouseIn) {
        ServiceExecute.compare(storeHouseInMapper.insert(storeHouseIn), ServiceExecute.ExecuteStatus.INSERT);
        StoreHouse storeHouse = storeHouseMapper.selectOne(new LambdaQueryWrapper<StoreHouse>()
                .eq(StoreHouse::getCommodityId, storeHouseIn.getCommodityId()));
        return storeHouseMapper.updateById(storeHouse.setStock(storeHouse.getStock() + storeHouseIn.getRealInNumber()));
    }

    @Override
    public int update(StoreHouseIn storeHouseIn) {
        return storeHouseInMapper.updateById(storeHouseIn);
    }

    @Override
    public int delete(String id) {
        return storeHouseInMapper.deleteById(id);
    }
}
