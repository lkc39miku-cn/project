package org.example.config.rabbit;

public interface RabbitConfigInterface {
    interface Exchange {
        String directExchange = "amq.direct";
        String topicExchange = "amq.topic";
        String fanoutExchange = "amq.fanout";
        String headersExchange = "amq.headers";
        String deadExchange = "dlx.direct";
    }

    abstract class Rabbit {
        protected abstract void rabbitName();
    }
}
