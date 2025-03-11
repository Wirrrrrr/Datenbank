package com.datenbank.DB.DBKlassen.postgres.Model.Cinema;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Entity
public class Row {

    @Id
    private Character rowKey;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "row_key")  // Fremdschlüssel in Seat
    private List<Seat> seats = new ArrayList<>();

    public Optional<Seat> getSeat(Integer seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber() == seatNumber) {
                return Optional.of(seat);
            }
        }
        return Optional.empty();
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }
}
