package com.datenbank.ActiveMQ;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.JMSException;
import javax.jms.Destination;

@Configuration
public class ActiveMQConfig {

    @Bean
    public Destination requestQueue(Session session) throws JMSException {
        return session.createQueue("requestQueue");
    }

    @Bean
    public Destination responseQueue(Session session) throws JMSException {
        return session.createQueue("responseQueue");
    }
}
