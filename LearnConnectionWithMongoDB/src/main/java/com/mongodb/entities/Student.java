package com.mongodb.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {
    private int id;
    private String name;
    private String city;
    private String collage;

    public Student() {
    }

    public Student(int id, String name, String city, String collage) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.collage = collage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }
}
