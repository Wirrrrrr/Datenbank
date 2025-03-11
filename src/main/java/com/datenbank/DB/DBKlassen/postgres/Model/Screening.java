package com.datenbank.DB.DBKlassen.postgres.Model;

import com.datenbank.DB.DBKlassen.postgres.Model.Cinema.Cinema;
import com.datenbank.DB.DBKlassen.postgres.Model.Cinema.Seat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Screening {

    private Long screeningID;

    private Map<Long, SeatStatus> reservations;

    private LocalDateTime startTime;

    private Cinema location;

    private Movie movie;

    public Screening(Cinema location) {
        this.location = location;
        this.reservations = clearReservations();
    }


    private Map<Long, SeatStatus> clearReservations() {
        HashMap<Long, SeatStatus> reservationsMap = new HashMap<>();
        location.getRows().forEach(
                row -> {
                    row.getSeats().forEach(
                            seat -> reservationsMap.put(seat.getSeatID(),SeatStatus.Free)
                    );
                }
                );

        return reservationsMap;
    }

    public void reserveSeat(Seat seat) {
        SeatStatus current = reservations.get(seat.getSeatID());
        if (current == SeatStatus.Free) {
            reservations.put(seat.getSeatID(), SeatStatus.Reserved);
        }else throw new RuntimeException(seat.getSeatNumber() + " is already reserved.");
    }

    public void unreserveSeat(Seat seat) {
        SeatStatus current = reservations.get(seat.getSeatID());
        if (current == SeatStatus.Booked) {
            throw new RuntimeException(seat.getSeatNumber() + " is already booked.");
        }else {
            reservations.put(seat.getSeatID(), SeatStatus.Free);
        }
    }

    public void bookSeat(Seat seat) {
        SeatStatus current = reservations.get(seat.getSeatID());
        if (current == SeatStatus.Booked) {
            throw new RuntimeException(seat.getSeatNumber() + " is already booked.");
        }else {
            reservations.put(seat.getSeatID(), SeatStatus.Booked);
        }
    }
}
