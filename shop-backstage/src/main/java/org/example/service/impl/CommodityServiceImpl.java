package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.StoreHouse;
import org.example.key.StoreHouseKey;
import org.example.mapper.CommodityMapper;
import org.example.service.CommodityService;
import org.example.entity.Commodity;
import org.example.entity.convert.CommodityConvert;
import org.example.entity.param.CommodityParam;
import org.example.mapper.StoreHouseMapper;
import org.example.result.ServiceExecute;
import org.example.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private CommodityConvert commodityConvert;
    @Autowired
    private StoreHouseMapper storeHouseMapper;

    @Override
    public IPage<Commodity> selectListByPage(CommodityParam commodityParam) {
        return commodityMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()),  new LambdaQueryWrapper<Commodity>()
                .eq(Objects.nonNull(commodityParam.getPublishStatus()), Commodity::getPublishStatus, commodityParam.getPublishStatus())
                .eq(Objects.nonNull(commodityParam.getDeleteStatus()), Commodity::getDeleteStatus, commodityParam.getDeleteStatus()));
    }

    @Override
    public int insert(Commodity commodity) {
        ServiceExecute.compare(commodityMapper.insert(commodity), ServiceExecute.ExecuteStatus.INSERT);
        return storeHouseMapper.insert(new StoreHouse()
                .setCommodityId(commodity.getId())
                .setDeleteStatus(StoreHouseKey.DELETE_STATUS_OFF)
                .setLowStock(0)
                .setStock(0)
                .setStoreHouseInfo(""));
    }

    @Override
    public int update(Commodity commodity) {
        return commodityMapper.updateById(commodity);
    }

    @Override
    public int delete(String id) {
        return commodityMapper.deleteById(id);
    }
}
