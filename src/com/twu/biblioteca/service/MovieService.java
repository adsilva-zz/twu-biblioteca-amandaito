package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.repository.MovieRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieRepository getMovieRepository() {
        return movieRepository;
    }

    public List<Movie> getListOfMovies() {
        return this.movieRepository.getListOfMovies();
    }

    public void checkoutMovie(Movie movie) {
        movie.setCheckout(true);
    }

    public Movie findBookWithIdentifier(Long identifier) {
        return movieRepository.findBookWithIdentifier(identifier);
    }

    public List<String> listOfMoviesWithColumns() {
        return getListOfMovies().stream().filter(movie -> !movie.isCheckout())
                .map(Movie::toString).collect(Collectors.toList());
    }
}
