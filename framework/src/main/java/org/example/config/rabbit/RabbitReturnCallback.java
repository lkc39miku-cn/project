package org.example.config.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitReturnCallback implements RabbitTemplate.ReturnsCallback {
    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        log.info("message body: {}", returnedMessage.getMessage());
        log.info("reply code: {}", returnedMessage.getReplyCode());
        log.info("reply context: {}", returnedMessage.getReplyText());
        log.info("exchange: {}", returnedMessage.getExchange());
        log.info("router key: {}", returnedMessage.getRoutingKey());
    }
}
