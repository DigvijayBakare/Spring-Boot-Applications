package com.unittesting.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Person {
    @Id
    private Integer personId;
    private String name;
    private String city;

    public Person() {
    }

    public Person(Integer personId, String name, String city) {
        this.personId = personId;
        this.name = name;
        this.city = city;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
