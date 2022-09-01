package org.example.config.mq.config;

import lombok.extern.slf4j.Slf4j;
import org.example.config.rabbit.RabbitConfigInterface;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderMQ implements RabbitConfigInterface {
    static class OrderTimeout extends RabbitConfigInterface.Rabbit {
        @Override
        public void rabbitName() {
            log.info("rabbitName: order timeout");
        }

        private static final String ORDER_TIMEOUT_DIRECT_QUEUE = "order_timeout";
        private static final String ORDER_TIMEOUT_DEAD_QUEUE = "order_timeout_dead";
        private static final String ORDER_TIMEOUT_DIRECT_DEAD_KEY = "order_key_dead";
    }

    @Bean("order_time_out_dead")
    public Queue queueDl() {
        return QueueBuilder.nonDurable(OrderTimeout.ORDER_TIMEOUT_DEAD_QUEUE)
                .build();
    }

    @Bean("directExchangeDead")
    public org.springframework.amqp.core.Exchange exchangeDead() {
        return ExchangeBuilder.directExchange(Exchange.deadExchange).build();
    }

    @Bean("bindingDead")
    public Binding bindingDl(@Qualifier("order_time_out_dead") Queue queue, @Qualifier("directExchangeDead") org.springframework.amqp.core.Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(OrderTimeout.ORDER_TIMEOUT_DIRECT_DEAD_KEY).noargs();
    }

    @Bean("directExchange")
    public org.springframework.amqp.core.Exchange exchange() {
        return ExchangeBuilder.directExchange(Exchange.directExchange).build();
    }

    @Bean("order_timeout")
    public Queue queue() {
        return QueueBuilder.nonDurable(OrderTimeout.ORDER_TIMEOUT_DIRECT_QUEUE)
                .deadLetterExchange(Exchange.deadExchange)
                .deadLetterRoutingKey(OrderTimeout.ORDER_TIMEOUT_DIRECT_DEAD_KEY)
                .build();
    }

    @Bean("binding")
    public Binding binding(@Qualifier("order_timeout") Queue queue, @Qualifier("directExchange") org.springframework.amqp.core.Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("msg.send").noargs();
    }
}
