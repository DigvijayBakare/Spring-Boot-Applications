package com.multidb.mongodb.repositories;

import com.multidb.mongodb.entities.ProductMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepositoryMongo extends MongoRepository<ProductMongo, Integer> {
    public ProductMongo findByName(String name);
}
