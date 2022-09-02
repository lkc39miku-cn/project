package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.example.entity.OrderInfo;
import org.example.entity.param.OrderInfoParam;
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
    public List<OrderInfo> select(OrderInfoParam orderInfoParam) {
        return orderInfoMapper.selectList(new LambdaQueryWrapper<OrderInfo>()
                .eq(StringUtils.isNotEmpty(orderInfoParam.getOrderId()), OrderInfo::getOrderId, orderInfoParam.getOrderId()));
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
        return orderInfoMapper.updateById((OrderInfo) new OrderInfo()
                .setDeleteStatus(1)
                .setId(id));
    }
}
