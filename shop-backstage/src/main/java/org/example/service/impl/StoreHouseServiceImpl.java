package org.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.StoreHouse;
import org.example.entity.convert.StoreHouseConvert;
import org.example.entity.param.StoreHouseParam;
import org.example.mapper.StoreHouseMapper;
import org.example.service.StoreHouseService;
import org.example.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreHouseServiceImpl implements StoreHouseService {
    @Autowired
    private StoreHouseMapper storeHouseMapper;
    @Autowired
    private StoreHouseConvert storeHouseConvert;

    @Override
    public IPage<StoreHouse> selectListByPage(StoreHouseParam storeHouseParam) {
        return storeHouseMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), null);
    }

    @Override
    public int insert(StoreHouse storeHouse) {
        return storeHouseMapper.insert(storeHouse);
    }

    @Override
    public int update(StoreHouse storeHouse) {
        return storeHouseMapper.updateById(storeHouse);
    }

    @Override
    public int delete(String id) {
        return storeHouseMapper.deleteById(id);
    }
}
