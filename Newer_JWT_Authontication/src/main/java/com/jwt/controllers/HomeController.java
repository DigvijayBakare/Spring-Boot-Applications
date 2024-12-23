package com.jwt.controllers;

import com.jwt.entities.Users;
import com.jwt.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/users")
    public List<Users> getUser() {
        System.out.println("Getting users!!");
//        return "user";
        return this.userService.getUsers();
    }

    @GetMapping("/current-user")
    public String getCurrentUser(Principal principal) {
        return principal.getName();
    }
}
