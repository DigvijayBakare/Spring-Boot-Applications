package com.task.Author_Titile_Project.service;

import com.task.Author_Titile_Project.entities.Author;
import com.task.Author_Titile_Project.entities.Title;
import com.task.Author_Titile_Project.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author saveAuthor(Author author) {
        // Set the relationship on both sides
        for (Title title : author.getTitles()) {
            title.getAuthors().add(author);
        }
        return authorRepository.save(author);
    }

    public Optional<Author> getAuthorById(Long authorId) {
        return authorRepository.findById(authorId);
    }
}

