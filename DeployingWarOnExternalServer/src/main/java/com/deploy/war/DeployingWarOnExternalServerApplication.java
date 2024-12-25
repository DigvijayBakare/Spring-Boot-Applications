package com.deploy.war;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// extends the class to SpringBootServletInitializer
@SpringBootApplication
public class DeployingWarOnExternalServerApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(DeployingWarOnExternalServerApplication.class, args);
    }

    // overriding method to return builder of the class

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DeployingWarOnExternalServerApplication.class);
    }
}
