package org.example.service.impl;

import org.example.CommodityBrandService;
import org.example.mapper.CommodityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityBrandServiceImpl implements CommodityBrandService {
    @Autowired
    private CommodityMapper commodityMapper;
}
