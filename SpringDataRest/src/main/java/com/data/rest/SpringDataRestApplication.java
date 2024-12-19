package com.data.rest;

import com.data.rest.entities.Book;
import com.data.rest.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataRestApplication implements CommandLineRunner {
    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*Book book1 = new Book();
        book1.setTitle("First Book");
        book1.setContent("This is the content of first book");

        Book book2 = new Book();
        book2.setTitle("Second Book");
        book2.setContent("This is the content of second book");

        this.bookRepository.save(book1);
        this.bookRepository.save(book2);*/
    }
}
