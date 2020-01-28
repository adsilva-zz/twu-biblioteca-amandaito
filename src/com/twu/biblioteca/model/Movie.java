package com.twu.biblioteca.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Movie {

    private Long identifier;
    private String name;
    private LocalDate year;
    private String director;
    private Rating rating;
    private static long SEQUENCE;

    public Movie(String name, LocalDate year, String director, Rating rating) {
        this.identifier = ++SEQUENCE;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
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

    @Override
    public String toString() {
        return identifier + " | " + name +" | " + director + " | " + year.format(DateTimeFormatter.ISO_DATE) + " | " +
                rating;
    }
}
