package com.datenbank.DB.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.datenbank.DB.repository.mongo") // Paket für MongoDB Repositories
public class MongoConfig {
}

