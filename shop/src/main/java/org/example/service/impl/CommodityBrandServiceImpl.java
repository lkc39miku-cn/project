package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.entity.CommodityBrand;
import org.example.mapper.CommodityBrandMapper;
import org.example.mapper.CommodityMapper;
import org.example.service.CommodityBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommodityBrandServiceImpl implements CommodityBrandService {
    @Autowired
    private CommodityBrandMapper commodityBrandMapper;

    @Override
    public List<CommodityBrand> select() {
        return commodityBrandMapper.selectList(null);
    }
}
