package com.task.Author_Titile_Project.service;

import com.task.Author_Titile_Project.entities.Title;
import com.task.Author_Titile_Project.repositories.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TitleService {

    @Autowired
    private TitleRepository titleRepository;

    public Title saveTitle(Title title) {
        return titleRepository.save(title);
    }

    public Optional<Title> getTitleById(Long titleId) {
        return titleRepository.findById(titleId);
    }
}
