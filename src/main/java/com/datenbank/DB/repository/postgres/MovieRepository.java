package com.datenbank.DB.repository.postgres;

import com.datenbank.DB.DBKlassen.postgres.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}

