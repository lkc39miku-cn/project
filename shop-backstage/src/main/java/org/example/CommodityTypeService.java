package org.example;

import org.example.entity.CommodityType;
import org.example.entity.vo.CommodityTypeVo;
import org.example.entity.vo.CommodityVo;
import org.example.entity.vo.DeptVo;

import java.util.List;

public interface CommodityTypeService {

    List<CommodityTypeVo> selectList();
    List<CommodityTypeVo> tree(List<CommodityTypeVo> commodityTypeVoList);

    int insert(CommodityType commodityType);

    int update(CommodityType commodityType);

    int delete(String id);
}
