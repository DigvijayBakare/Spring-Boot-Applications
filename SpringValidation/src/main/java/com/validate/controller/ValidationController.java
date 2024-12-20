package com.validate.controller;

import com.validate.entities.LoginData;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ValidationController {
    @GetMapping("/form")
    public String openForm(Model m) {
        System.out.println("Inside form handler");
        m.addAttribute("loginData", new LoginData());
        return "form";
    }

    // handler for processing the form
    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result);
            return "form";
        }
        System.out.println(loginData);
        return "success";
    }
}
