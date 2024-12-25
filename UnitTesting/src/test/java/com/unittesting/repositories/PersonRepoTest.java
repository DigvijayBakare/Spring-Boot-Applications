package com.unittesting.repositories;

import com.unittesting.entities.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class PersonRepoTest {
    @Autowired
    private PersonRepo personRepo;
    @Test
    void isPersonExistById() {
        Person person = new Person(123, "Digvijay", "Pune");
        personRepo.save(person);

        Boolean actualResult = personRepo.isPersonExistById(123);

        assertThat(actualResult).isTrue();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing down!!");
        personRepo.deleteAll();
    }

    @BeforeEach
    void setUp() {
        System.out.println("Setting up!!");
    }
}