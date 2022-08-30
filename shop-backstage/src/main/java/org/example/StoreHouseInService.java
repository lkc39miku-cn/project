package org.example;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.entity.StoreHouse;
import org.example.entity.StoreHouseIn;
import org.example.entity.param.StoreHouseInParam;

public interface StoreHouseInService {
    IPage<StoreHouseIn> selectListByPage(StoreHouseInParam storeHouseInParam);

    int insert(StoreHouseIn storeHouseIn);

    int update(StoreHouseIn storeHouseIn);

    int delete(String id);
}
