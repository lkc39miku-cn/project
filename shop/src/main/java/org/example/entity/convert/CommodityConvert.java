package org.example.entity.convert;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.entity.Commodity;
import org.example.entity.vo.CommodityVo;
import org.example.mapper.CommodityBrandMapper;
import org.example.mapper.CommodityTypeMapper;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class CommodityConvert implements Convert<Commodity, CommodityVo> {
    @Autowired
    private CommodityTypeMapper commodityTypeMapper;
    @Autowired
    private CommodityBrandMapper commodityBrandMapper;
    @Override
    public abstract CommodityVo convert(Commodity commodity);
    @Override
    public abstract List<CommodityVo> convert(List<Commodity> commodityList);

    @AfterMapping
    public void convert(Commodity commodity, @MappingTarget CommodityVo commodityVo) {
        commodityVo.setCommodityBrand(commodityBrandMapper.selectById(commodity.getCommodityBrandId()))
                .setCommodityType(commodityTypeMapper.selectById(commodity.getCommodityTypeId()));
    }

    @AfterMapping
    public void convert(List<Commodity> commodityList, @MappingTarget List<CommodityVo> commodityVoList) {
        commodityVoList.forEach(v -> convert(null, v));
    }
}