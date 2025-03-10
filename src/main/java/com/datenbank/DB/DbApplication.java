package com.datenbank.DB;

import com.datenbank.DB.repository.mongo.SaalRepository;
import com.datenbank.DB.repository.postgres.RowRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbApplication.class, args);
	}

}
