package org.example.service;

import com.alipay.api.AlipayApiException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.entity.Order;
import org.example.entity.param.OrderParam;

import javax.servlet.http.HttpServletRequest;

public interface OrderService {
    int insert(OrderParam orderParam);

    void pay(HttpServletRequest request) throws AlipayApiException;

    IPage<Order> selectListByPage(OrderParam orderParam);
}
