package com.caching.services;

import com.caching.entity.Book;
import com.caching.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BookServiceImpl implements BookService{
    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        logger.info("Adding book with id - {}", book.getId());
        return bookRepository.save(book);
    }

    @Override
    @CachePut(cacheNames = "books", key = "#book.id")
    public Book updateBook(Book book) {
//        bookRepository.updateAddress(book.getId(), book.getName());       // only updating name of the book
        bookRepository.save(book);
        logger.info("Book updated with new details!");
        return book;
    }

    @Override
    @Cacheable(cacheNames = "books", key = "#id")
    public Book getBook(long id) {
        logger.info("Fetching book from the db!");
        Optional<Book> book = bookRepository.findById((int) id);
        if (book.isPresent()){
            return book.get();
        } else {
            return new Book();
        }
    }

    @Override
    @CacheEvict(cacheNames = "books", key = "#id")
    public String deleteBook(long id) {
        bookRepository.deleteById((int) id);
        return "Book deleted successfully!";
    }
}
