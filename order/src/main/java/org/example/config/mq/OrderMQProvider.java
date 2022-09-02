package org.example.config.mq;

import lombok.extern.slf4j.Slf4j;
import org.example.config.rabbit.RabbitConfigInterface;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderMQProvider {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Async
    public void send(String message, String userId) {
        rabbitTemplate.convertAndSend(RabbitConfigInterface.Exchange.directExchange, OrderMQ.OrderTimeout.ORDER_TIMEOUT_DIRECT_KEY, message, message1 -> {
            message1.getMessageProperties().setExpiration("60000");
            message1.getMessageProperties().setMessageId(userId);
            return message1;
        });
    }
}
