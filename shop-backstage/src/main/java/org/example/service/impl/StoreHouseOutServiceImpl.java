package org.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.StoreHouseOut;
import org.example.entity.convert.StoreHouseOutConvert;
import org.example.entity.param.StoreHouseOutParam;
import org.example.mapper.StoreHouseOutMapper;
import org.example.StoreHouseOutService;
import org.example.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreHouseOutServiceImpl implements StoreHouseOutService {
    @Autowired
    private StoreHouseOutMapper storeHouseOutMapper;
    @Autowired
    private StoreHouseOutConvert storeHouseOutConvert;

    @Override
    public IPage<StoreHouseOut> selectListByPage(StoreHouseOutParam storeHouseOutParam) {
        return storeHouseOutMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), null);
    }

    @Override
    public int insert(StoreHouseOut storeHouseOut) {
        return storeHouseOutMapper.insert(storeHouseOut);
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
