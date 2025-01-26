package com.task.Author_Titile_Project.repositories;

import com.task.Author_Titile_Project.entities.Title;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<Title, Long> {
    // Custom queries (if needed) can be added here
}
