package com.twu.biblioteca.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Movie {

    private Long identifier;
    private String name;
    private LocalDate year;
    private String director;
    private Rating rating;
    private User user;
    private boolean checkout;
    private static long SEQUENCE;

    public Movie(Long identifier, String name, LocalDate year, String director, Rating rating, Boolean checkout) {
        this.identifier = identifier;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.checkout = checkout;

    }

    public Movie(String name, LocalDate year, String director, Rating rating, Boolean checkout) {
        this(++SEQUENCE, name, year, director, rating, checkout);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public boolean isCheckout() {
        return checkout;
    }

    public void setCheckout(boolean checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return identifier + " | " + name +" | " + director + " | " + year.format(DateTimeFormatter.ISO_DATE) + " | " +
                rating;
    }
}
