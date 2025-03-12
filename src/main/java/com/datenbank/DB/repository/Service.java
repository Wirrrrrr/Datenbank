package com.datenbank.DB.repository;

import com.datenbank.DB.DBKlassen.postgres.Model.Cinema.Cinema;
import com.datenbank.DB.repository.postgres.*;
import lombok.RequiredArgsConstructor;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {
    private final BookingRepository bookingRepository;
    private final CinemaRepository cinemaRepository;
    private final MovieRepository movieRepository;
    private final ReservationRepository reservationRepository;
    private final RowRepository rowRepository;
    private final ScreeningRepository screeningRepository;
    private final SeatRepository seatRepository;
    private final TicketRepository ticketRepository;

    public Cinema saveCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

}
