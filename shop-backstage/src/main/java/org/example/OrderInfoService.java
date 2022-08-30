package org.example;

import org.example.entity.OrderInfo;
import org.example.entity.param.OrderInfoParam;

import java.util.List;

public interface OrderInfoService {
    List<OrderInfo> selectList(OrderInfoParam orderInfoParam);

    int insert(OrderInfo orderInfo);

    int update(OrderInfo orderInfo);

    int delete(String id);
}
