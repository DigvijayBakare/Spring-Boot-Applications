package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.BookRepository;
import com.entities.Book;

@Component
public class BookServices {
    @Autowired
    private BookRepository bookRepository;
    /*private static List<Book> bookList = new ArrayList<>();
    static {
        bookList.add(new Book(12, "Java Core", "Mohan"));
        bookList.add(new Book(14, "Java 8", "Angad"));
        bookList.add(new Book(16, "HTML Basics", "Ravi"));
    }*/

    // get all books
    public List<Book> getAllBooks() {
        List<Book> bookList = (List<Book>) this.bookRepository.findAll();
        return bookList;
    }

    // get single book by id
    public Book getBookById(int id) {
        Book book = null;
        try {
            // book = bookList.stream().filter(b -> b.getBookId() == id).findFirst().get();
          book= this.bookRepository.findByBookId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // adding a new book in the list or database
    public Book addBook(Book b) {
        // bookList.add(b);
        Book result = this.bookRepository.save(b);
        return result;
    }

    // delete book
    public void deleteBook(int bookId) {
        // bookList = bookList.stream().filter(b -> b.getBookId() != bookId).collect(Collectors.toList());
        bookRepository.deleteById(bookId);
    }

    // update a book
    public void updateBook(Book book, int bookId) {
        /*bookList = bookList.stream().map(b -> {
            if (b.getBookId() == bookId) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());*/

        book.setBookId(bookId);
        bookRepository.save(book);
    }
}
