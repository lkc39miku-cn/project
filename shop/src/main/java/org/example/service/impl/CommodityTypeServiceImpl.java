package org.example.service.impl;

import org.example.entity.CommodityType;
import org.example.mapper.CommodityTypeMapper;
import org.example.service.CommodityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityTypeServiceImpl implements CommodityTypeService {
    @Autowired
    private CommodityTypeMapper commodityTypeMapper;

    @Override
    public List<CommodityType> select() {
        return commodityTypeMapper.selectList(null);
    }
}
