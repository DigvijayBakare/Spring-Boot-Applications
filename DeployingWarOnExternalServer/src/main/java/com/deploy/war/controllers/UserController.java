package com.deploy.war.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @GetMapping("/users")
    public List getUsers() {
        return List.of("Digvijay", "Angad", "Vishnu", "Krishna");
    }
}
