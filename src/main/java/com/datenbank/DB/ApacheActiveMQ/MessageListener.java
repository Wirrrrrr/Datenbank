package com.datenbank.DB.ApacheActiveMQ;

import Commands.Command;
import Commands.CommandSerializer;
import com.datenbank.DB.ApacheActiveMQ.Commands.Cinema.SaveCinemaCommand;
import com.datenbank.DB.ApacheActiveMQ.Commands.Cinema.SaveRowCommand;
import com.datenbank.DB.ApacheActiveMQ.Commands.Cinema.SaveSeatCommand;
import com.datenbank.DB.repository.postgres.CinemaRepository;
import com.datenbank.DB.repository.postgres.RowRepository;
import com.datenbank.DB.repository.postgres.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageListener {

    private final MessageSender messageSender;

    private final RowRepository rowRepository;

    private final SeatRepository seatRepository;

    private final CinemaRepository cinemaRepository;

    @JmsListener(destination = "requestQueue")
    public void receiveRequest(String json) {
        try {
            Command<?> command = CommandSerializer.deserialize(json);
            System.out.println("Empfangenes Command: " + command.getId());

            command.execute(); // Command ausführen

            //Unaussprechlicher If-Block
            if (command instanceof SaveCinemaCommand saveCinemaCommand) {
               ;
                saveCinemaCommand.setResult(cinemaRepository.save(saveCinemaCommand.getCinema()));
            }
            if (command instanceof SaveRowCommand saveRowCommand) {
                saveRowCommand.setResult(rowRepository.save(saveRowCommand.getRow()));
            }
            if (command instanceof SaveSeatCommand saveSeatCommand) {
                saveSeatCommand.setResult(seatRepository.save(saveSeatCommand.getSeat()));
            }


            messageSender.sendResponse(command); // Antwort zurücksenden
        } catch (Exception e) {
            System.err.println("Fehler bei der Verarbeitung der Anfrage: " + e.getMessage());
        }
    }
}
