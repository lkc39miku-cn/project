package org.example;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.entity.Order;
import org.example.entity.param.OrderParam;

public interface OrderService {
    IPage<Order> selectListByPage(OrderParam orderParam);

    int insert(Order order);

    int update(Order order);

    int delete(String id);
}
