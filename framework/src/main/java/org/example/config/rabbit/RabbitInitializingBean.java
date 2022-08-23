package org.example.config.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitInitializingBean implements InitializingBean {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RabbitConfirmCallBack rabbitConfirmCallBack;
    @Autowired
    private RabbitReturnCallback rabbitReturnCallback;


    @Override
    public void afterPropertiesSet() {
        rabbitTemplate.setConfirmCallback(rabbitConfirmCallBack);
        rabbitTemplate.setReturnsCallback(rabbitReturnCallback);
    }
}
