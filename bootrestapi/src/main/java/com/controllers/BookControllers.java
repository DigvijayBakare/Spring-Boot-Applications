package com.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Book;
import com.services.BookServices;

@RestController
public class BookControllers {
    @Autowired
    private BookServices bookServices;

    // get all books handler
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBook() {
        List<Book> list = this.bookServices.getAllBooks();
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        // return ResponseEntity.of(Optional.of(list));
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    // get single book handler
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        Book book = this.bookServices.getBookById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    // creater new book handler
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book b) {
        try {
            Book book = this.bookServices.addBook(b);
            return ResponseEntity.of(Optional.of(book));
        } catch (Exception e) {
            e.printStackTrace();
            return (ResponseEntity<Book>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete a book handler
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
        try {
            this.bookServices.deleteBook(bookId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return (ResponseEntity<Void>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // update book handler
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") int id) {
        try {
            this.bookServices.updateBook(book, id);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
            e.printStackTrace();
            return (ResponseEntity<Book>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
