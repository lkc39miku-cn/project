package org.example.service;

import org.example.entity.Order;
import org.example.entity.param.OrderParam;

import javax.servlet.http.HttpServletRequest;

public interface OrderService {
    int insert(OrderParam orderParam);

    void pay(HttpServletRequest request);
}
