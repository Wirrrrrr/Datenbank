package com.datenbank.DB.ApacheActiveMQ;

import Commands.Command;
import Commands.CommandSerializer;
import Commands.Commands.*;
import Commands.Commands.Cinema.*;
import com.datenbank.DB.repository.mongo.RevenueRepository;
import com.datenbank.DB.repository.postgres.*;
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

    private final MovieRepository movieRepository;

    private final ReservationRepository reservationRepository;

    private final BookingRepository bookingRepository;

    private final ScreeningRepository screeningRepository;
    private final RevenueRepository revenueRepository;

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
                case FindMovieCommand findMovieCommand -> {
                    findMovieCommand.setResult(movieRepository.find(findMovieCommand.getMovieId()));
                }
                case FindReservationCommand findReservationCommand -> {
                    findReservationCommand.setResult(reservationRepository.find(findReservationCommand.getReservationId()));
                }
                case DeleteReservationCommand deleteReservationCommand -> {
                    reservationRepository.delete(deleteReservationCommand.getReservation());
                    deleteReservationCommand.setResult(true);
                }
                case FindBookingCommand findBookingCommand -> {
                    findBookingCommand.setResult(bookingRepository.find(findBookingCommand.getBookingId()));
                }
                case FindScreeningByMovieCommand findScreeningByMovieCommand -> {
                    findScreeningByMovieCommand.setResult(screeningRepository.findByMovie(findScreeningByMovieCommand.getMovieId()));
                }
                case FindScreeningCommand findScreeningCommand -> {
                    findScreeningCommand.setResult(screeningRepository.find(findScreeningCommand.getScreeningId()));
                }
                case FindCinemaCommand findCinemaCommand -> {
                    findCinemaCommand.setResult(cinemaRepository.find(findCinemaCommand.getCinemaId()));
                }
                case FindRowCommand findRowCommand -> {
                    findRowCommand.setResult(rowRepository.find(findRowCommand.getRowKey()));
                }
                case FindSeatCommand findSeatCommand -> {
                    findSeatCommand.setResult(seatRepository.find(findSeatCommand.getSeatId()));
                }
                case SaveReservationCommand saveReservationCommand -> {
                    reservationRepository.save(saveReservationCommand.getReservation());
                    saveReservationCommand.setResult(true);
                }
                case SaveRevenueCommand saveRevenueCommand -> {
                    revenueRepository.save(saveRevenueCommand.getRevenue());
                    saveRevenueCommand.setResult(true);
                }
                case SaveBookingCommand saveBookingCommand -> {
                    bookingRepository.save(saveBookingCommand.getBooking());
                    saveBookingCommand.setResult(true);
                }
                case SaveMovieCommand saveMovieCommand -> {
                    movieRepository.save(saveMovieCommand.getMovie());
                    saveMovieCommand.setResult(true);
                }
                case SaveScreeningCommand saveScreeningCommand -> {
                    screeningRepository.save(saveScreeningCommand.getScreening());
                    saveScreeningCommand.setResult(true);
                }


                default -> throw new IllegalArgumentException("Unbekanntes Command: " + command.getClass().getName());

            }
                messageSender.sendResponse(command); // Antwort zurücksenden
            } catch(Exception e){
                System.err.println("Fehler bei der Verarbeitung der Anfrage: " + e.getMessage());
            }

    }
}
