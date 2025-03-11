package com.datenbank.DB.ApacheActiveMQ;

import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.jms.Queue;

@Configuration
public class ActiveMQConfig {

    @Bean
    public Queue requestQueue() {
        return new ActiveMQQueue("requestQueue");
    }

    @Bean
    public Queue responseQueue() {
        return new ActiveMQQueue("responseQueue");
    }
}
