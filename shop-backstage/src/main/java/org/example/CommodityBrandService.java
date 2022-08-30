package org.example;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.entity.CommodityBrand;
import org.example.entity.param.CommodityBrandParam;

public interface CommodityBrandService {
    IPage<CommodityBrand> selectListByPage(CommodityBrandParam commodityBrandParam);

    int insert(CommodityBrand commodityBrand);

    int update(CommodityBrand commodityBrand);

    int delete(String id);
}
