package com.email.controller;

import com.email.model.Email;
import com.email.model.EmailResponse;
import com.email.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class EmailController {
    @Autowired
    private EmailService emailService;

    @RequestMapping("/welcome")
    public String welcome() {
        return "Hello this is my email api..";
    }

    // api to send email
    @PostMapping("/sendEmail")
    public ResponseEntity<?> sendEmail(@RequestBody Email request) {
        System.out.println(request);
        boolean result = this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());
        if (result) {
            return ResponseEntity.ok(new EmailResponse("Email sent successfully!!"));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Something went wrong!!"));
        }
    }
}
