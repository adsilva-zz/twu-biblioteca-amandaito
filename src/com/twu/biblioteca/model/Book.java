package com.twu.biblioteca.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Book {
    private String author;
    private String title;
    private LocalDate yearPublished;
    private boolean checkout;

    public Book(String author, String title, LocalDate yearPublished, boolean checkout) {
        this.author = author;
        this.title = title;
        this.yearPublished = yearPublished;
        this.checkout = checkout;
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

    public boolean isCheckout() {
        return checkout;
    }

    public void setCheckout(boolean checkout) {
        this.checkout = checkout;
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
