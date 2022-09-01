package org.example.config.mq;

import lombok.extern.slf4j.Slf4j;
import org.example.config.rabbit.RabbitConfigInterface;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KillMQProvider {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Async
    public void send(String message, String orderId) {
        rabbitTemplate.convertAndSend(RabbitConfigInterface.Exchange.directExchange, KillMQ.KillOrder.KILL_ORDER_DIRECT_KEY, message, message1 -> {
            message1.getMessageProperties().setExpiration("30000");
            message1.getMessageProperties().setMessageId(orderId);
            return message1;
        });
    }
}
