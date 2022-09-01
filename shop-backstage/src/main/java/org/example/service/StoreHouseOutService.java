package org.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.entity.StoreHouseOut;
import org.example.entity.param.StoreHouseOutParam;

public interface StoreHouseOutService {
    IPage<StoreHouseOut> selectListByPage(StoreHouseOutParam storeHouseOutParam);

    int insert(StoreHouseOut storeHouseOut);

    int update(StoreHouseOut storeHouseOut);

    int delete(String id);
}
