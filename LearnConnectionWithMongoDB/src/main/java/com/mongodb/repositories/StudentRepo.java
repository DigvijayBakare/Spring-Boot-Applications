package com.mongodb.repositories;

import com.mongodb.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, Integer> {
}
