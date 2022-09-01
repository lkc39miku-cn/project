package org.example.service;

import org.example.entity.OrderInfo;

import java.util.List;

public interface OrderInfoService {
    List<OrderInfo> select();

    int insert(OrderInfo orderInfo);

    int update(OrderInfo orderInfo);

    int delete(String id);
}
