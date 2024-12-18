package com.thymeleaf.Thymeleaf_With_SpringBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CSSJSController {
    @GetMapping("/example")
    public String example() {
        return "example";
    }
}
