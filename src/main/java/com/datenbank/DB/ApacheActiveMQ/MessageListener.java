package com.datenbank.DB.ApacheActiveMQ;

import Commands.Command;
import Commands.CommandSerializer;
import Commands.Commands.Cinema.SaveCinemaCommand;
import Commands.Commands.Cinema.SaveRowCommand;
import Commands.Commands.Cinema.SaveSeatCommand;
import Commands.Commands.SaveBookingCommand;
import Commands.Commands.SaveMovieCommand;
import Commands.Commands.SaveScreeningCommand;
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

    private final CinemaRepository cinemaRepository;

    private final SeatRepository seatRepository;

    private final RowRepository rowRepository;

    @JmsListener(destination = "requestQueue")
    public void receiveRequest(String json) {
        try {
            Command<?> command = CommandSerializer.deserialize(json);
            System.out.println("Empfangenes Command: " + command.getId());

            command.execute(); // Command ausführen


            //Unaussprechlicher If-Block
            switch (command) {
                case SaveCinemaCommand saveCinemaCommand ->
                     {
                         System.out.println(saveCinemaCommand.getCinema().toString());
                         saveCinemaCommand.setResult(cinemaRepository.save(saveCinemaCommand.getCinema()));
                     }

                case SaveRowCommand saveRowCommand ->
                        saveRowCommand.setResult(rowRepository.save(saveRowCommand.getRow()));

                case SaveSeatCommand saveSeatCommand -> {
                    System.out.println("Empfangener Command: " + saveSeatCommand.getSeat().toString());
                    saveSeatCommand.setResult(seatRepository.save(saveSeatCommand.getSeat()));
                }

    /*case SaveBookingCommand saveBookingCommand -> {
        datenbankService.save(saveBookingCommand.getBooking());
        saveBookingCommand.setResult(true);
    }

    case SaveMovieCommand saveMovieCommand -> {
        datenbankService.save(saveMovieCommand.getMovie());
        saveMovieCommand.setResult(true);
    }

    case SaveScreeningCommand saveScreeningCommand -> {
        datenbankService.save(saveScreeningCommand.getScreening());
        saveScreeningCommand.setResult(true);

    }
*/

                default -> throw new IllegalArgumentException("Unbekanntes Command: " + command.getClass().getName());

            }
                messageSender.sendResponse(command); // Antwort zurücksenden
            } catch(Exception e){
                System.err.println("Fehler bei der Verarbeitung der Anfrage: " + e.getMessage());
            }

    }
}
