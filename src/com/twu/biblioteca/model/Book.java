package com.twu.biblioteca.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Book {
    private String author;
    private String title;
    private LocalDate yearPublished;

    public Book(String author, String title, LocalDate yearPublished) {
        this.author = author;
        this.title = title;
        this.yearPublished = yearPublished;
    }

    public LocalDate getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(LocalDate yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return author + " | " + yearPublished.format(DateTimeFormatter.ISO_DATE);
    }
}
