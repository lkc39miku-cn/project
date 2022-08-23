package org.example.mq.config;

import lombok.extern.slf4j.Slf4j;
import org.example.config.rabbit.RabbitConfigInterface;

@Slf4j
public class Test implements RabbitConfigInterface {
    static class Rabbit extends RabbitConfigInterface.Rabbit {
        public void rabbitName() {
            log.info("rabbitName: Test");
        }

    }



}
