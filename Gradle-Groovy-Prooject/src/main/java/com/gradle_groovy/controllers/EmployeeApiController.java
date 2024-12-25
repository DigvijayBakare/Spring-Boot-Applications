package com.gradle_groovy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeApiController {
    @GetMapping("/{id}")
    public String getEmployee(String id) {
        return "Employee Found!!";
    }

    @GetMapping("/response")
    public ResponseEntity<?> getResponse() {
        return ResponseEntity.ok("This is response entity method");
    }
}
