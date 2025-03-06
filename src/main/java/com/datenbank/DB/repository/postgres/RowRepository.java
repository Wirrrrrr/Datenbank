package com.datenbank.DB.repository.postgres;

import com.datenbank.DB.DBKlassen.postgres.Row;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RowRepository extends JpaRepository<Row, Long> {
}
