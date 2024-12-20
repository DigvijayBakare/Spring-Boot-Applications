package com.filejson.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.filejson.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ObjectMapper mapper;

    @PostMapping("/add-user")
    public ResponseEntity<Map<String, String>> addUserInfo(@RequestParam("file") MultipartFile file,
                                           @RequestParam("user") String user) {
        this.logger.info("add user request!");
        logger.info("File information: {}", file.getOriginalFilename());
//        logger.info("user : {}", user);
        Map<String, String> response = new HashMap<>();
        /// converting string into json
        User user1 = null;
        try {
            user1 = mapper.readValue(user, User.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            response.put("message", "Invalid Request!");
            return ResponseEntity.ok(response);
        }

        // printing user data
        logger.info("User data is {} ", user1);
        response.put("message", "Done!");
//        return ResponseEntity.status(HttpStatus.OK).body("Done!");
        return ResponseEntity.ok(response);
    }
}
