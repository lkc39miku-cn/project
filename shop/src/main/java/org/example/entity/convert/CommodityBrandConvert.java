package org.example.entity.convert;

import org.example.entity.CommodityBrand;
import org.example.entity.CommodityType;
import org.example.entity.vo.CommodityBrandVo;
import org.example.entity.vo.CommodityTypeVo;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class CommodityBrandConvert implements Convert<CommodityBrand, CommodityBrandVo> {
    @Override
    public abstract CommodityBrandVo convert(CommodityBrand commodityBrand);

    @Override
    public abstract List<CommodityBrandVo> convert(List<CommodityBrand> commodityBrandList);

    @AfterMapping
    public void convert(CommodityBrand commodityBrand, @MappingTarget CommodityBrandVo commodityBrandVo) {

    }

    @AfterMapping
    public void convert(List<CommodityBrand> commodityBrandList, @MappingTarget List<CommodityBrandVo> commodityBrandVoList) {
        commodityBrandVoList.forEach(v -> convert(null, v));
    }
}
