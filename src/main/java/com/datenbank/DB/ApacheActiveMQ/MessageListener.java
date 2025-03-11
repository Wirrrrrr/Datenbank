package com.datenbank.DB.ApacheActiveMQ;

import Commands.Command;
import Commands.CommandSerializer;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageListener {

    private final MessageSender messageSender;

    @JmsListener(destination = "requestQueue")
    public void receiveRequest(String json) {
        try {
            Command<?> command = CommandSerializer.deserialize(json);
            System.out.println("Empfangenes Command: " + command.getId());

            command.execute(); // Command ausführen

            messageSender.sendResponse(command); // Antwort zurücksenden
        } catch (Exception e) {
            System.err.println("Fehler bei der Verarbeitung der Anfrage: " + e.getMessage());
        }
    }
}
