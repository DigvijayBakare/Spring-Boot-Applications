package com.deploy.war.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String homePage() {
        return "home";
    }

    @RequestMapping("/about")
    public String aboutPage() {
        System.out.println();
        return "about";
    }
}
