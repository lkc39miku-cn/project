package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.example.CommodityBrandService;
import org.example.entity.CommodityBrand;
import org.example.entity.StoreHouse;
import org.example.entity.convert.CommodityBrandConvert;
import org.example.entity.param.CommodityBrandParam;
import org.example.key.CommodityBrandKey;
import org.example.mapper.CommodityBrandMapper;
import org.example.mapper.CommodityMapper;
import org.example.mapper.StoreHouseMapper;
import org.example.result.ServiceExecute;
import org.example.util.PageUtil;
import org.example.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CommodityBrandServiceImpl implements CommodityBrandService {
    @Autowired
    private CommodityBrandMapper commodityBrandMapper;
    @Autowired
    private CommodityBrandConvert commodityBrandConvert;
    @Autowired
    private StoreHouseMapper storeHouseMapper;
    @Autowired
    private RedisCache redisCache;

    @Override
    public IPage<CommodityBrand> selectListByPage(CommodityBrandParam commodityBrandParam) {
        return commodityBrandMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), new LambdaQueryWrapper<CommodityBrand>()
                .eq(Objects.nonNull(commodityBrandParam.getPublishStatus()), CommodityBrand::getPublishStatus, commodityBrandParam.getPublishStatus()));
    }

    @Override
    public int insert(CommodityBrand commodityBrand) {
        return commodityBrandMapper.insert(commodityBrand);
    }

    @Override
    public int update(CommodityBrand commodityBrand) {
        return commodityBrandMapper.updateById(commodityBrand);
    }

    @Override
    public int delete(String id) {
        return commodityBrandMapper.deleteById(id);
    }
}
