package org.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.mapper.CommodityMapper;
import org.example.CommodityService;
import org.example.entity.Commodity;
import org.example.entity.convert.CommodityConvert;
import org.example.entity.param.CommodityParam;
import org.example.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private CommodityConvert commodityConvert;

    @Override
    public int insert(Commodity commodity) {
        return 0;
    }

    @Override
    public int update(Commodity commodity) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }
}
