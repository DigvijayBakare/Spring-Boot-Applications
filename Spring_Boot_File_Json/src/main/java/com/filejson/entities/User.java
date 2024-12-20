package com.filejson.entities;


import com.filejson.customValidations.ImageNameValid;

public class User {
    private int id;
    private String name;
    private String city;
    private String imageName;

    public User() {
    }

    public User(int id, String name, String city, String imageName) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.imageName = imageName;
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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "User {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", imageName='" + imageName + '\'' +
                '}';
    }
}
