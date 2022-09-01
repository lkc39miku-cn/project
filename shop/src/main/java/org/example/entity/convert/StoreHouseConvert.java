package org.example.entity.convert;

import org.example.entity.StoreHouse;
import org.example.entity.vo.StoreHouseVo;
import org.example.mapper.CommodityMapper;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class StoreHouseConvert implements Convert<StoreHouse, StoreHouseVo> {
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private CommodityConvert commodityConvert;
    @Override
    public abstract StoreHouseVo convert(StoreHouse storeHouse);
    @Override
    public abstract List<StoreHouseVo> convert(List<StoreHouse> storeHouseList);

    @AfterMapping
    public void convert(StoreHouse storeHouse, @MappingTarget StoreHouseVo storeHouseVo) {
        storeHouseVo
                .setCommodityVo(commodityConvert.convert(commodityMapper.selectById(storeHouseVo.getCommodityId())));
    }

    @AfterMapping
    public void convert(List<StoreHouse> storeHouseList, @MappingTarget List<StoreHouseVo> storeHouseVoList) {
        storeHouseVoList.forEach(v -> convert(null, v));
    }
}
