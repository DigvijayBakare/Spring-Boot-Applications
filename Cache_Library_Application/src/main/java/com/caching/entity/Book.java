package com.caching.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String category;
    private String author;
    private String publisher;
    private String edition;

    public Book() {
    }

    public Book(long id, String name, String category, String author, String publisher, String edition) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.author = author;
        this.publisher = publisher;
        this.edition = edition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "Book {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", edition='" + edition + '\'' +
                '}';
    }
}
