package com.datenbank.DB.repository.postgres;

import com.datenbank.DB.DBKlassen.postgres.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}

