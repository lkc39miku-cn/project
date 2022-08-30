package org.example.service.impl;

import org.example.entity.CommodityType;
import org.example.entity.convert.CommodityTypeConvert;
import org.example.entity.vo.CommodityVo;
import org.example.mapper.CommodityTypeMapper;
import org.example.CommodityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityTypeServiceImpl implements CommodityTypeService {
    @Autowired
    private CommodityTypeMapper commodityTypeMapper;
    @Autowired
    private CommodityTypeConvert commodityTypeConvert;

    @Override
    public List<CommodityVo> tree() {
        return null;
    }

    @Override
    public int insert(CommodityType commodityType) {
        return commodityTypeMapper.insert(commodityType);
    }

    @Override
    public int update(CommodityType commodityType) {
        return commodityTypeMapper.updateById(commodityType);
    }

    @Override
    public int delete(String id) {
        return commodityTypeMapper.deleteById(id);
    }
}
