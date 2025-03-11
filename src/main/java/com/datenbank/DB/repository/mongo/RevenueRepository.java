package com.datenbank.DB.repository.mongo;

import com.datenbank.DB.DBKlassen.Revenue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends MongoRepository<Revenue, String> {
    Revenue getTop(String name);
}
