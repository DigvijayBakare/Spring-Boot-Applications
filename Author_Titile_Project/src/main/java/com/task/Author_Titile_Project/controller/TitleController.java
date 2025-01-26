package com.task.Author_Titile_Project.controller;

import com.task.Author_Titile_Project.entities.Title;
import com.task.Author_Titile_Project.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/titles")
public class TitleController {

    @Autowired
    private TitleService titleService;

    @PostMapping
    public Title createTitle(@RequestBody Title title) {
        return titleService.saveTitle(title);
    }

    @GetMapping("/{id}")
    public Optional<Title> getTitleById(@PathVariable Long id) {
        return titleService.getTitleById(id);
    }
}

