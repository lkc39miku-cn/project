package org.example.service;

import org.example.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> select();

    int insert(Order order);

    int update(Order order);
}
