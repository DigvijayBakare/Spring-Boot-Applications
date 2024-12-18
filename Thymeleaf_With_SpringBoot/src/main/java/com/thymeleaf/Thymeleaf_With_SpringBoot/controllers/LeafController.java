package com.thymeleaf.Thymeleaf_With_SpringBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
public class LeafController {
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model model) {
        System.out.println("Inside about handler");
        model.addAttribute("name", "Digvijay");
        return "about";
    }

    @GetMapping("/new")
    public String newAbout(Model model) {
        System.out.println("Inside new about handler");
        return "aboutNew";
    }
    @GetMapping("/contact")
    public String contact(Model model) {
        System.out.println("Inside contact handler");
        return "contact";
    }
    @GetMapping("/iterate")
    public String iterateHandler(Model model) {
        System.out.println("Inside about iterator handler");
        List<String> names = Arrays.asList("Digvijay", "Angad", "Vishnu", "Krishna");
        model.addAttribute("names", names);
        return "iterate";
    }

    @GetMapping("/conditional")
    public String conditionalHandler(Model model) {
        System.out.println("Inside conditional handler");
        List<String> names = Arrays.asList("Digvijay", "Angad", "Vishnu", "Krishna");
        model.addAttribute("isActive", false);
        model.addAttribute("gender", "M");
        List<Integer> list = List.of(2, 5, 3, 6, 4, 1, 9, 7, 8, 10);
        model.addAttribute("list", list);
        return "conditional";
    }

    @GetMapping("/fragment")
    public String fragmentHandler(Model model) {
        System.out.println("Inside fragment handler");
        model.addAttribute("title", "I like to eat samosa");
        model.addAttribute("subtitle", LocalDateTime.now().toString());
        return "fragment";
    }
}
