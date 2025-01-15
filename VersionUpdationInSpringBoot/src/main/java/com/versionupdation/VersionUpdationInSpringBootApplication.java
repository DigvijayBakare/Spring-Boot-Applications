package com.versionupdation;

import com.versionupdation.helper.LoggerWrapper;
//import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Digvijay
 */

@SpringBootApplication
public class VersionUpdationInSpringBootApplication {
    private static final LoggerWrapper logger = LoggerWrapper.getLogger(VersionUpdationInSpringBootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(VersionUpdationInSpringBootApplication.class, args);
        logger.info("Application started!");
    }
}
