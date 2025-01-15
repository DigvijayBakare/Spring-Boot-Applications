package com.versionupdation.repository;

import com.versionupdation.entities.Person;
import com.versionupdation.helper.LoggerWrapper;
//import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PersonRepository {
    private static final LoggerWrapper logger = LoggerWrapper.getLogger(PersonRepository.class);
    static Map<Integer, Person> personMap = new HashMap<>();

    public Person save(Person person) {
        int personId = person.getId();
        logger.info("Person saved into the DB successfully!");
        return personMap.put(personId, person);
    }

    public Person update(int pId, Person person) {
        Person available = personMap.get(pId);
        if (personMap.containsValue(available)) {
            logger.info("Person with id: {}" + pId + " saved successfully");
            return personMap.put(pId, person);
        }
        logger.error("Something went wrong!!");
        return new Person();
    }

    public List<Person> getAllPersons() {
        logger.info("List of all persons returned successfully!");
        return new ArrayList<>(personMap.values());
    }

    public Person delete(int pId) {
        Person remove = personMap.remove(pId);
        logger.info("Person with id: " + pId + " deleted successfully!");
        return remove;
    }
}
