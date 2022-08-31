package org.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.Order;
import org.example.entity.convert.OrderConvert;
import org.example.entity.param.OrderParam;
import org.example.mapper.OrderMapper;
import org.example.service.OrderService;
import org.example.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderConvert orderConvert;

    @Override
    public IPage<Order> selectListByPage(OrderParam orderParam) {
        return orderMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), null);
    }

    @Override
    public int insert(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public int update(Order order) {
        return orderMapper.updateById(order);
    }

    @Override
    public int delete(String id) {
        return orderMapper.deleteById(id);
    }
}
