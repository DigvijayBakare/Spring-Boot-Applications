package com.multidb.mongodb.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.multidb.mongodb.repositories")
public class MongoDBConfig {

    @Autowired
    private Environment environment;

    // MongoClient Bean
    @Bean
    public MongoClient mongoClient() {
        String connectionString = environment.getProperty("spring.mongodb.connection-string");
        return MongoClients.create(connectionString);
    }

    // MongoDatabaseFactory Bean
    @Bean
    public MongoDatabaseFactory mongoDatabaseFactory() {
        return new SimpleMongoClientDatabaseFactory(mongoClient(), environment.getProperty("spring.data.mongodb.database"));
    }

    // MongoTemplate Bean
    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDatabaseFactory());
    }
}
