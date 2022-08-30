package org.example.entity.convert;


import org.example.entity.OrderInfo;
import org.example.entity.vo.OrderInfoVo;
import org.example.mapper.CommodityMapper;
import org.example.mapper.UserMapper;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class OrderInfoConvert implements Convert<OrderInfo, OrderInfoVo> {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private CommodityConvert commodityConvert;
    @Override
    public abstract OrderInfoVo convert(OrderInfo orderInfo);

    @Override
    public abstract List<OrderInfoVo> convert(List<OrderInfo> orderInfoList);

    @AfterMapping
    public void convert(OrderInfo orderInfo, @MappingTarget OrderInfoVo orderInfoVo) {
        orderInfoVo
                .setCommodityVo(commodityConvert.convert(commodityMapper.selectById(orderInfoVo.getCommodityId())));
    }

    @AfterMapping
    public void convert(List<OrderInfo> orderInfoList, @MappingTarget List<OrderInfoVo> orderInfoVoList) {
        orderInfoVoList.forEach(v -> convert(null, v));
    }
}
