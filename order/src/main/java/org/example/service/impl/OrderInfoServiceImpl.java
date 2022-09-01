package org.example.service.impl;

import org.example.entity.OrderInfo;
import org.example.mapper.OrderInfoMapper;
import org.example.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    public List<OrderInfo> select() {
        return orderInfoMapper.selectList(null);
    }

    @Override
    public int insert(OrderInfo orderInfo) {
        return orderInfoMapper.insert(orderInfo);
    }

    @Override
    public int update(OrderInfo orderInfo) {
        return orderInfoMapper.updateById(orderInfo);
    }

    @Override
    public int delete(String id) {
        return orderInfoMapper.deleteById(id);
    }
}
