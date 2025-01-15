package com.versionupdation.service;

import com.versionupdation.entities.Person;

import java.util.List;

public interface PersonService {
    public void savePerson(Person person);
    public void updatePerson(int pid, Person person);
    public List<Person> getAllPersons();
    public void deletePerson(int pId);
}
