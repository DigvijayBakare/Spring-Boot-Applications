package com.dao;

import org.springframework.data.repository.CrudRepository;
import com.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
    public Book findByBookId(int bookId);
}
