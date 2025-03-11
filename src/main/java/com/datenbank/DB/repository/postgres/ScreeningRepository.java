package com.datenbank.DB.repository.postgres;

import com.datenbank.DB.DBKlassen.postgres.Model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
}

