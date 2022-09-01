package org.example.config.mq;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.example.config.rabbit.RabbitConfigInterface;
import org.example.entity.Order;
import org.example.mapper.OrderMapper;
import org.example.service.OrderService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = OrderMQ.OrderTimeout.ORDER_TIMEOUT_DEAD_QUEUE),
        exchange = @Exchange(value = RabbitConfigInterface.Exchange.deadExchange),
        key = OrderMQ.OrderTimeout.ORDER_TIMEOUT_DIRECT_DEAD_KEY
))
public class OrderListener {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderMapper orderMapper;

    @RabbitHandler
    public void onMessage(@Payload String message, Channel channel, @Headers Map<String, Object> headers) throws Exception {
        log.info("message: {}", message);

        try {
            Order order = JSONObject.parseObject(message, Order.class);
            if (Objects.isNull(order)) {
                log.error("order is null");
                return;
            }

            Order selectById = orderMapper.selectById(order.getId());
            if (Objects.isNull(selectById)) {
                log.error("order is null");
                return;
            }

            if (order.getOrderType() == 1) {
                orderMapper.deleteById(order.setOrderType(2));
                log.info("store + 1");
            }

            Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
