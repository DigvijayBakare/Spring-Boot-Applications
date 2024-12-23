package com.jwt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class HomeController {
    @RequestMapping("/welcome")
    public String welcome() {
        String text = "This is private page,";
        text += " this page is not allowed to unauthenticated users";
        return text;
    }

    @RequestMapping("/getUser")
    public String getUser() {

        return "{\"name\":\"Digvijay\"}";
    }
}
