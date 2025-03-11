package com.datenbank.DB.ApacheActiveMQ;

import Commands.Command;
import Commands.CommandSerializer;
import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import jakarta.jms.Queue;

@Service
@AllArgsConstructor
public class MessageSender {

    private final JmsTemplate jmsTemplate;
    private final Queue responseQueue;

    public void sendResponse(Command<?> command) {
        try {
            String json = CommandSerializer.serialize(command);
            jmsTemplate.convertAndSend(responseQueue, json);
            System.out.println("Antwort gesendet: " + command.getId());
        } catch (Exception e) {
            System.err.println("Fehler beim Senden der Antwort: " + e.getMessage());
        }
    }
}

