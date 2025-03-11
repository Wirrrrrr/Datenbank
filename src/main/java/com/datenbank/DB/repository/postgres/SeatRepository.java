package com.datenbank.DB.repository.postgres;

import com.datenbank.DB.DBKlassen.postgres.Model.Cinema.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}

