package com.caching.services;

import com.caching.entity.Book;

public interface BookService {
    public Book addBook(Book book);
    public Book updateBook(Book book);
    public Book getBook(long id);
    public String deleteBook(long id);
}
