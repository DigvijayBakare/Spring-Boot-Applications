package com.caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheLibraryApplication {
    public static void main(String[] args) {
        SpringApplication.run(CacheLibraryApplication.class, args);
    }
}
