package com.twu.biblioteca.model;

import java.time.LocalDate;

public class Movie {

    private Long identifier;
    private String name;
    private LocalDate year;
    private String director;
    private Rating rating;
    private static long SEQUENCE;
}
