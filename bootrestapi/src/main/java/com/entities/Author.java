package com.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement
public class Author {
    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int authorId;
    private String name;
    private String language;

    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Book book;
}
