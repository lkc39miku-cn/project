package org.example;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.entity.Commodity;
import org.example.entity.param.CommodityParam;

public interface CommodityService {
    int insert(Commodity commodity);

    int update(Commodity commodity);

    int delete(String id);
}
