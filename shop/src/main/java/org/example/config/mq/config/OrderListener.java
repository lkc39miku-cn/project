package org.example.config.mq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderListener {

//    @RabbitListener(queues = "order_timeout", containerFactory = "listenerContainer")
//    public void order(Message message) {
//        log.info("order: {}", message);
//    }
//
//    @RabbitListener(queues = "order_timeout_dead", containerFactory = "listenerContainer")
//    public void orderTimeout(Message message) {
//        log.info("order timeout: {}", message);
//    }
}
