package org.example.service;

import com.alipay.api.AlipayApiException;
import org.example.entity.Order;
import org.example.entity.param.OrderParam;

import javax.servlet.http.HttpServletRequest;

public interface OrderService {
    int insert(OrderParam orderParam);

    void pay(HttpServletRequest request) throws AlipayApiException;
}
