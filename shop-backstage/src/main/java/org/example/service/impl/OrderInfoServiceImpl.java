package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.entity.OrderInfo;
import org.example.entity.convert.OrderInfoConvert;
import org.example.entity.param.OrderInfoParam;
import org.example.mapper.OrderInfoMapper;
import org.example.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private OrderInfoConvert orderInfoConvert;

    @Override
    public List<OrderInfo> selectList(OrderInfoParam orderInfoParam) {
        return orderInfoMapper.selectList(new LambdaQueryWrapper<OrderInfo>()
                .eq(orderInfoParam.getOrderId() != null, OrderInfo::getOrderId, orderInfoParam.getOrderId()));
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
