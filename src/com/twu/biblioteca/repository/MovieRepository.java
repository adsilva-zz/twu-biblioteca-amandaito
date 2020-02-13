package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Movie;

import java.util.List;

public interface MovieRepository {

    public List<Movie> getListOfMovies();

    public Movie findMovieWithIdentifier(Long identifier);
}
