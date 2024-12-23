package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})     // this is how we can disable auto config classes in spring boot
@SpringBootApplication
public class LibApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibApiApplication.class, args);
    }
}
