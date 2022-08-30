package org.example;

import org.example.entity.CommodityType;
import org.example.entity.vo.CommodityVo;

import java.util.List;

public interface CommodityTypeService {
    List<CommodityVo> tree();

    int insert(CommodityType commodityType);

    int update(CommodityType commodityType);

    int delete(String id);
}
