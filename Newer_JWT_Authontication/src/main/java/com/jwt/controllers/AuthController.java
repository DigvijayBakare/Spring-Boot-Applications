package com.jwt.controllers;

import com.jwt.entities.Users;
import com.jwt.impl.UserServiceImpl;
import com.jwt.models.JwtRequest;
import com.jwt.models.JwtResponse;
import com.jwt.security.JwtHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
        this.doAuthenticate(request.getEmail(), request.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = this.helper.generateToken(userDetails);
//        JwtResponse response = JwtResponse.builder().jwtToken(token)
//                .userName(userDetails.getUsername()).build();
        JwtResponse response = new JwtResponse(token, userDetails.getUsername());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authenticationToken);
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid username or password!!");
        }
    }

    @PostMapping("/create-user")
    public Users createUser(@RequestBody Users users) {
        return userService.createUser(users);
    }
}
