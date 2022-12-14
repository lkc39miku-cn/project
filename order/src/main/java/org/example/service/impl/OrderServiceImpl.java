package org.example.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.config.AlipayConfig;
import org.example.config.mq.OrderMQProvider;
import org.example.entity.Order;
import org.example.entity.param.OrderParam;
import org.example.mapper.CommodityMapper;
import org.example.mapper.OrderInfoMapper;
import org.example.mapper.OrderMapper;
import org.example.result.ServiceExecute;
import org.example.service.OrderService;
import org.example.util.PageUtil;
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
    public void pay(HttpServletRequest request) throws AlipayApiException {
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();

        for (String name : requestParams.keySet()) {
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }

            //??????
            valueStr = new String(valueStr.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            params.put(name, valueStr);
        }

        // ??????
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.SIGN_TYPE);

        if (signVerified) {
            // ?????????
            String outTradeNo = params.get("out_trade_no");
            // ??????????????????
            String tradeNo = params.get("trade_no");
            // ????????????
            String totalAmount = params.get("total_amount");

            // ??????????????????
//            orderMapper.update(new Order().setOrderTypeId(9L), new QueryWrapper<Order>().eq("order_number", outTradeNo));

            // ????????????????????????
//            Order order = orderMapper.selectOne(new QueryWrapper<Order>().eq("order_number", outTradeNo));
//            List<OrderInfo> orderInfoList = orderInfoMapper.selectList(new QueryWrapper<OrderInfo>().eq("order_id", order.getId()));
//
//            for (OrderInfo orderInfo : orderInfoList) {
//                orderInfoMapper.updateById(orderInfo.setOrderTypeId(2L));
//            }

            // ????????????
            log.info("===============alipay start===============");
            log.info("????????????{}", outTradeNo);
            log.info("?????????????????????{}", tradeNo);
            log.info("???????????????{}", totalAmount);
        } else {
            log.info("===============alipay start===============");
            log.info("?????????????????????");
        }
        log.info("===============alipay end===============");
    }

    @Override
    public IPage<Order> selectListByPage(OrderParam orderParam) {
        return orderMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), new LambdaQueryWrapper<Order>()
                .eq(StringUtils.isNotEmpty(orderParam.getType()), Order::getOrderType, orderParam.getType()));
    }
}
