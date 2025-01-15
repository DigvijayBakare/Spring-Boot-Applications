package com.versionupdation.controller;

import com.versionupdation.entities.Person;
import com.versionupdation.helper.LoggerWrapper;
import com.versionupdation.service.impl.PersonServiceImpl;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private static final LoggerWrapper logger = LoggerWrapper.getLogger(PersonController.class);

    @Autowired
    private PersonServiceImpl personService;

    @PostMapping("/create/person")
    public ResponseEntity<?> createPerson(@RequestBody Person person) {
        if (person.getId() != 0) {
            personService.savePerson(person);
            return ResponseEntity.ok("Person saved successfully!!");
        }
        return ResponseEntity.badRequest().body("Error while saving Person data!!");
    }

    @PutMapping("/update/person/{pId}")
    public ResponseEntity<?> updatePerson(@PathVariable("pId") int pId, @RequestBody Person person) {
        personService.updatePerson(pId, person);
        return ResponseEntity.ok("Person updated successfully!!");
    }

    @DeleteMapping("/delete/person/{pId}")
    public ResponseEntity<?> deletePerson(@PathVariable int pId) {
        personService.deletePerson(pId);
        return ResponseEntity.ok("Person deleted successfully!!");
    }

    @GetMapping("/getall/person")
    public List<Person> getAllPerson() {
        List<Person> allPersons = personService.getAllPersons();
        logger.info("Returned all person data successfully!!");
        return allPersons;
    }
}
