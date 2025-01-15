package com.versionupdation.service.impl;

import com.versionupdation.entities.Person;
import com.versionupdation.helper.LoggerWrapper;
import com.versionupdation.repository.PersonRepository;
import com.versionupdation.service.PersonService;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private static final LoggerWrapper logger = LoggerWrapper.getLogger(PersonServiceImpl.class);

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
        logger.info("Person saved successfully!");
    }

    @Override
    public void updatePerson(int pid, Person person) {
        personRepository.update(pid, person);
    }

    @Override
    public List<Person> getAllPersons() {
        List<Person> allPersons = personRepository.getAllPersons();
        return allPersons;
    }

    @Override
    public void deletePerson(int pId) {
        personRepository.delete(pId);
        logger.info("Person deleted successfully!");
    }
}
