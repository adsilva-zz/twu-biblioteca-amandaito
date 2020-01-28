package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Movie;

import java.util.List;

public class MovieRepositoryImpl implements MovieRepository {

    private List<Movie> listOfMovies;

    public MovieRepositoryImpl(List<Movie> listOfMovies) {
        this.listOfMovies = listOfMovies;
    }

    @Override
    public List<Movie> getListOfMovies() {
        return listOfMovies;
    }
}
