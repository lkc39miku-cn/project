package org.example.config.mq;

import lombok.extern.slf4j.Slf4j;
import org.example.config.rabbit.RabbitConfigInterface;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KillMQ  implements RabbitConfigInterface {
    static class KillOrder extends RabbitConfigInterface.Rabbit {
        @Override
        public void rabbitName() {
            log.info("rabbitName: kill order");
        }

        public static final String KILL_ORDER_DIRECT_QUEUE = "kill_order";
        public static final String KILL_ORDER_DEAD_QUEUE = "kill_order_dead";
        public static final String KILL_ORDER_DIRECT_KEY = "kill.msg.send";
        public static final String KILL_ORDER_DIRECT_DEAD_KEY = "kill_key_dead";

    }

    @Bean("kill_order_dead")
    public Queue queueDl() {
        return QueueBuilder.nonDurable(KillOrder.KILL_ORDER_DEAD_QUEUE)
                .build();
    }

    @Bean("directExchangeDead")
    public org.springframework.amqp.core.Exchange exchangeDead() {
        return ExchangeBuilder.directExchange(Exchange.deadExchange).build();
    }

    @Bean("bindingDeadKill")
    public Binding bindingDl(@Qualifier("kill_order_dead") Queue queue, @Qualifier("directExchangeDead") org.springframework.amqp.core.Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(KillOrder.KILL_ORDER_DIRECT_DEAD_KEY).noargs();
    }

    @Bean("kill_order")
    public Queue queue() {
        return QueueBuilder.nonDurable(KillOrder.KILL_ORDER_DIRECT_QUEUE)
                .deadLetterExchange(Exchange.deadExchange)
                .deadLetterRoutingKey(KillOrder.KILL_ORDER_DIRECT_DEAD_KEY)
                .build();
    }

    @Bean("directExchange")
    public org.springframework.amqp.core.Exchange exchange() {
        return ExchangeBuilder.directExchange(Exchange.directExchange).build();
    }

    @Bean("bindingKill")
    public Binding binding(@Qualifier("kill_order") Queue queue, @Qualifier("directExchange") org.springframework.amqp.core.Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(KillMQ.KillOrder.KILL_ORDER_DIRECT_KEY).noargs();
    }
}
