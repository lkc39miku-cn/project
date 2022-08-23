package org.example.config.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitConfirmCallBack implements RabbitTemplate.ConfirmCallback {
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info("message only tips: {}", correlationData);
        log.info("message status: {}", ack);
        log.info("message result: {}", cause);
    }
}
