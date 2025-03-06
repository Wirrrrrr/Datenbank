package com.datenbank.DB.repository.mongo;

import com.datenbank.DB.DBKlassen.Saal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaalRepository extends MongoRepository<Saal, String> {
    Saal findByName(String name);
}
