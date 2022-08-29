package org.example.entity.convert;

import org.example.entity.Order;
import org.example.entity.vo.OrderVo;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class OrderConvert implements Convert<Order, OrderVo> {
    @Override
    public abstract OrderVo convert(Order order);

    @Override
    public abstract List<OrderVo> convert(List<Order> orderList);

    @AfterMapping
    public void convert(Order order, @MappingTarget OrderVo orderVo) {

    }

    @AfterMapping
    public void convert(List<Order> orderList, @MappingTarget List<OrderVo> orderVoList) {
        orderVoList.forEach(v -> convert(null, v));
    }
}
