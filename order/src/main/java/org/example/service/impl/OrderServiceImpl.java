package org.example.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.config.AlipayConfig;
import org.config.mq.OrderMQProvider;
import org.example.entity.Order;
import org.example.entity.param.OrderParam;
import org.example.mapper.CommodityMapper;
import org.example.mapper.OrderInfoMapper;
import org.example.mapper.OrderMapper;
import org.example.result.ServiceExecute;
import org.example.service.OrderService;
import org.example.util.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderMQProvider orderMQProvider;
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    public int insert(OrderParam orderParam) {
        ServiceExecute.compare(orderMapper.insert(orderParam), ServiceExecute.ExecuteStatus.INSERT);
        orderMQProvider.send(JSON.toJSONString(orderParam), UserThreadLocal.getUser().getId());

        orderParam.getOrderInfoList()
                .forEach(v -> {
                    ServiceExecute.compare(orderInfoMapper.insert(v.setOrderType(0)), ServiceExecute.ExecuteStatus.INSERT);
                });
        return 1;
    }

    @Override
    public void pay(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();

        for (String name : requestParams.keySet()) {
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }

            //乱码
            valueStr = new String(valueStr.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            params.put(name, valueStr);
        }

        // 验签
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.SIGN_TYPE);

        if (signVerified) {
            // 订单号
            String outTradeNo = params.get("out_trade_no");
            // 支付宝订单号
            String tradeNo = params.get("trade_no");
            // 支付金额
            String totalAmount = params.get("total_amount");

            // 更新支付状态
            orderMapper.update(new Order().setOrderTypeId(9L), new QueryWrapper<Order>().eq("order_number", outTradeNo));

            // 更新订单详情状态
            Order order = orderMapper.selectOne(new QueryWrapper<Order>().eq("order_number", outTradeNo));
            List<OrderInfo> orderInfoList = orderInfoMapper.selectList(new QueryWrapper<OrderInfo>().eq("order_id", order.getId()));

            for (OrderInfo orderInfo : orderInfoList) {
                orderInfoMapper.updateById(orderInfo.setOrderTypeId(2L));
            }

            // 记录信息
            log.info("===============alipay start===============");
            log.info("订单号：{}", outTradeNo);
            log.info("支付宝订单号：{}", tradeNo);
            log.info("支付金额：{}", totalAmount);
        } else {
            log.info("===============alipay start===============");
            log.info("支付，验证失败");
        }
        log.info("===============alipay end===============");
    }
}
