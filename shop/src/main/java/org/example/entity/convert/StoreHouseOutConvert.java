package org.example.entity.convert;

import org.example.entity.StoreHouseOut;
import org.example.entity.vo.StoreHouseOutVo;
import org.example.mapper.StoreHouseMapper;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class StoreHouseOutConvert implements Convert<StoreHouseOut, StoreHouseOutVo> {
    @Autowired
    private StoreHouseMapper storeHouseMapper;
    @Autowired
    private StoreHouseConvert storeHouseConvert;

    @Override
    public abstract StoreHouseOutVo convert(StoreHouseOut storeHouseOut);

    @Override
    public abstract List<StoreHouseOutVo> convert(List<StoreHouseOut> storeHouseOutList);

    @AfterMapping
    public void convert(StoreHouseOut storeHouseOut, @MappingTarget StoreHouseOutVo storeHouseOutVo) {
        storeHouseOutVo
                .setStoreHouseVo(storeHouseConvert.convert(storeHouseMapper.selectById(storeHouseOutVo.getStoreHouseId())));
    }
    @AfterMapping
    public void convert(List<StoreHouseOut> storeHouseOutList, @MappingTarget List<StoreHouseOutVo> storeHouseOutVoList) {
        storeHouseOutVoList.forEach(v -> convert(null, v));
    }
}
