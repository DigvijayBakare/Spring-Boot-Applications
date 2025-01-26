package com.task.Author_Titile_Project.repositories;

import com.task.Author_Titile_Project.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Custom queries (if needed) can be added here
}

