package com.jwt.impl;

import com.jwt.entities.Users;
import com.jwt.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl {
//    private List<Users> store = new ArrayList<>();

    /*public UserServiceImpl() {
        store.add(new Users(UUID.randomUUID().toString(), "Digvijay", "digvijay@gmail.com"));
        store.add(new Users(UUID.randomUUID().toString(), "Mahesh", "mahesh@gmail.com"));
        store.add(new Users(UUID.randomUUID().toString(), "Ramesh", "ramesh@gmail.com"));
        store.add(new Users(UUID.randomUUID().toString(), "Suresh", "suresh@gmail.com"));
        store.add(new Users(UUID.randomUUID().toString(), "Durgesh", "durgesh@gmail.com"));
    }*/

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    public List<Users> getUsers() {
//        return this.store;
//    }

    public List<Users> getUsers() {
        return this.userRepo.findAll();
    }

    public Users createUser(Users users) {
        users.setUserId(UUID.randomUUID().toString());
        users.setPass(passwordEncoder.encode(users.getPass()));
        return this.userRepo.save(users);
    }
}
