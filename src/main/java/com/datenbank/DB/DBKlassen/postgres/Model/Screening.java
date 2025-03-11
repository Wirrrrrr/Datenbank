package com.datenbank.DB.DBKlassen.postgres.Model;

import com.datenbank.DB.DBKlassen.postgres.Model.Cinema.Cinema;
import com.datenbank.DB.DBKlassen.postgres.Model.Cinema.Seat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screeningID;

    private LocalDateTime startTime;

    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    private Cinema location;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ElementCollection
    @CollectionTable(name = "screening_reservations", joinColumns = @JoinColumn(name = "screening_id"))
    @MapKeyColumn(name = "seat_id")
    @Column(name = "seat_status")
    @Enumerated(EnumType.STRING)
    private Map<Long, SeatStatus> reservations = new HashMap<>();

    public Screening(Cinema location) {
        this.location = location;
        this.reservations = clearReservations();
    }

    private Map<Long, SeatStatus> clearReservations() {
        HashMap<Long, SeatStatus> reservationsMap = new HashMap<>();
        location.getRows().forEach(
                row -> row.getSeats().forEach(
                        seat -> reservationsMap.put(seat.getSeatID(), SeatStatus.Free)
                )
        );
        return reservationsMap;
    }

    public void reserveSeat(Seat seat) {
        SeatStatus current = reservations.get(seat.getSeatID());
        if (current == SeatStatus.Free) {
            reservations.put(seat.getSeatID(), SeatStatus.Reserved);
        } else {
            throw new RuntimeException(seat.getSeatNumber() + " is already reserved.");
        }
    }

    public void unreserveSeat(Seat seat) {
        SeatStatus current = reservations.get(seat.getSeatID());
        if (current == SeatStatus.Booked) {
            throw new RuntimeException(seat.getSeatNumber() + " is already booked.");
        } else {
            reservations.put(seat.getSeatID(), SeatStatus.Free);
        }
    }

    public void bookSeat(Seat seat) {
        SeatStatus current = reservations.get(seat.getSeatID());
        if (current == SeatStatus.Booked) {
            throw new RuntimeException(seat.getSeatNumber() + " is already booked.");
        } else {
            reservations.put(seat.getSeatID(), SeatStatus.Booked);
        }
    }
}

