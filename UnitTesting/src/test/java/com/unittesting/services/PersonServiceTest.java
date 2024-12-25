package com.unittesting.services;

import com.unittesting.repositories.PersonRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
    @Mock
    private PersonRepo personRepo;

    //    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
//        autoCloseable = MockitoAnnotations.openMocks(this);
        this.personService = new PersonService(this.personRepo);
    }

//    @AfterEach
//    void tearDown() {            // either use this one or use the @ExtendWith annotation
//        try {
//            this.autoCloseable.close();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    private PersonService personService;

    @Test
    void getAllPersons() {
        personService.getAllPersons();
        verify(personRepo).findAll();
    }
}