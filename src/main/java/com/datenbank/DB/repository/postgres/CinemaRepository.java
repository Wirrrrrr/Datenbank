package com.datenbank.DB.repository.postgres;

import com.datenbank.DB.DBKlassen.postgres.Model.Cinema.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}

