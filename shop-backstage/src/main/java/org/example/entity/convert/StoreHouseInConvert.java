package org.example.entity.convert;

import org.example.entity.StoreHouseIn;
import org.example.entity.vo.StoreHouseInVo;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class StoreHouseInConvert implements Convert<StoreHouseIn, StoreHouseInVo> {
    @Override
    public abstract StoreHouseInVo convert(StoreHouseIn storeHouseIn);

    @Override
    public abstract List<StoreHouseInVo> convert(List<StoreHouseIn> storeHouseInList);

    @AfterMapping
    public void convert(StoreHouseIn storeHouseIn, @MappingTarget StoreHouseInVo storeHouseInVo) {

    }

    @AfterMapping
    public void convert(List<StoreHouseIn> storeHouseInList, @MappingTarget List<StoreHouseInVo> storeHouseInVoList) {
        storeHouseInVoList.forEach(v -> convert(null, v));
    }
}
