package com.datenbank.ActiveMQ;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    private final MessageSender messageSender;

    public MessageListener(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @JmsListener(destination = "requestQueue")
    public void receiveMessage(String message) {
        System.out.println("📥 Anfrage empfangen: " + message);

        // Simulierte Verarbeitung
        String response = "Antwort auf: " + message;

        // Antwort zurück an die Webanwendung senden
        messageSender.sendResponse(response);
    }
}
