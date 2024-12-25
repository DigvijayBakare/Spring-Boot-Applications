package com.unittesting.services;

import com.unittesting.entities.Person;
import com.unittesting.repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;

    public List<Person> getAllPersons() {
        return this.personRepo.findAll();
    }

    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }
}
