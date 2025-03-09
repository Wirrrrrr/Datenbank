package com.datenbank.ActiveMQ;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
public class MessageSender {

    private final JmsTemplate jmsTemplate;
    private final Queue responseQueue;

    public MessageSender(JmsTemplate jmsTemplate, Queue responseQueue) {
        this.jmsTemplate = jmsTemplate;
        this.responseQueue = responseQueue;
    }

    public void sendResponse(String message) {
        jmsTemplate.convertAndSend(responseQueue, message);
        System.out.println("📨 Antwort gesendet: " + message);
    }
}
