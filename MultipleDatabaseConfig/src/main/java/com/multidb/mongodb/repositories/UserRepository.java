package com.multidb.mongodb.repositories;

import com.multidb.mongodb.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,Integer> {
}
