package org.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.entity.StoreHouse;
import org.example.entity.param.StoreHouseParam;

public interface StoreHouseService {
    IPage<StoreHouse> selectListByPage(StoreHouseParam storeHouseParam);

    int insert(StoreHouse storeHouse);

    int update(StoreHouse storeHouse);

    int delete(String id);
}
