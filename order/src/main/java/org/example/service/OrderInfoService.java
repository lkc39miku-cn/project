package org.example.service;

import org.example.entity.OrderInfo;
import org.example.entity.param.OrderInfoParam;

import java.util.List;

public interface OrderInfoService {
    List<OrderInfo> select(OrderInfoParam orderInfoParam);

    int insert(OrderInfo orderInfo);

    int update(OrderInfo orderInfo);

    int delete(String id);
}
