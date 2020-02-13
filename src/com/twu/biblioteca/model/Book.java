package com.twu.biblioteca.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Book {
    private Long identifier;
    private String author;
    private String title;
    private LocalDate yearPublished;
    private boolean checkout;
    private User user;
    private static long SEQUENCE;

    public Book(Long identifier, String author, String title, LocalDate yearPublished, boolean checkout) {
        this.author = author;
        this.title = title;
        this.yearPublished = yearPublished;
        this.checkout = checkout;
        this.identifier = identifier;
    }

    public Book(String author, String title, LocalDate yearPublished, boolean checkout) {
        this(++SEQUENCE, author, title, yearPublished, checkout);

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

    public Long getIdentifier() {
        return identifier;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return identifier + " | " + title +" | " + author + " | " + yearPublished.format(DateTimeFormatter.ISO_DATE);
    }

    public String viewUserChecked(){
        return getUser().getName() + " - " + toString();
    }
}
