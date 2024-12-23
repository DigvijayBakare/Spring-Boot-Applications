package com.actuators.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
    public Student() {
        System.out.println("Creating an object of a Student!!");
    }
}
