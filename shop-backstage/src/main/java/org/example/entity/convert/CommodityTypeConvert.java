package org.example.entity.convert;

import org.example.entity.CommodityType;
import org.example.entity.vo.CommodityTypeVo;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class CommodityTypeConvert implements Convert<CommodityType, CommodityTypeVo> {
    @Override
    public abstract CommodityTypeVo convert(CommodityType commodityType);

    @Override
    public abstract List<CommodityTypeVo> convert(List<CommodityType> commodityTypeList);

    @AfterMapping
    public void convert(CommodityType commodityType, @MappingTarget CommodityTypeVo commodityTypeVo) {

    }

    @AfterMapping
    public void convert(List<CommodityType> commodityTypeList, @MappingTarget List<CommodityTypeVo> commodityTypeVoList) {
        commodityTypeVoList.forEach(v -> convert(null, v));
    }
}
