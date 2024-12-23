package com.jwt;

import com.jwt.model.User;
import com.jwt.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtAuthenticationApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    public void createUsers() {
        User user = new User();
        user.setUserName("Digvijay");
        user.setPassword("abcdefg");
        user.setEmail("digvijaybakare816@gmail.com");
        user.setRole("Admin");
        user.setEnabled(true);
        User save = this.userRepository.save(user);
        System.out.println(save);
    }

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthenticationApplication.class, args);
//        new JwtAuthenticationApplication().createUsers();
    }

    @Override
    public void run(String... args) throws Exception {
        createUsers();
    }
}
