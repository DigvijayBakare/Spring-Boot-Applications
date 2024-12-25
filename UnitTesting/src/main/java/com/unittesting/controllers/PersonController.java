package com.unittesting.controllers;

import com.unittesting.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public ResponseEntity<?> allPersons() {
        return ResponseEntity.ok(this.personService.getAllPersons());
    }
}
