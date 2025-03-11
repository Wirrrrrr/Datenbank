package com.datenbank.DB.ApacheActiveMQ;

import Commands.Command;
import Commands.CommandSerializer;
import com.datenbank.DB.ApacheActiveMQ.Commands.Cinema.SaveCinemaCommand;
import com.datenbank.DB.ApacheActiveMQ.Commands.Cinema.SaveRowCommand;
import com.datenbank.DB.ApacheActiveMQ.Commands.Cinema.SaveSeatCommand;
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

            //Unaussprechlicher If-Block
            if (command instanceof SaveCinemaCommand saveCinemaCommand) {
                datenbankService.save(saveCinemaCommand.getCinema());
                saveCinemaCommand.setResult(true);
            }
            if (command instanceof SaveRowCommand saveRowCommand) {
                datenbankService.save(saveRowCommand.getRow());
                saveRowCommand.setResult(true);
            }
            if (command instanceof SaveSeatCommand saveSeatCommand) {
                datenbankService.save(saveSeatCommand.getSeat());
                saveSeatCommand.setResult(true);
            }


            messageSender.sendResponse(command); // Antwort zurücksenden
        } catch (Exception e) {
            System.err.println("Fehler bei der Verarbeitung der Anfrage: " + e.getMessage());
        }
    }
}
