package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;
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

    public boolean checkoutMovie(Long movieNumber, User user) {
        Movie founded = findMovieWithIdentifier(movieNumber);

        if (founded != null && !founded.isCheckout() && user != null) {
            founded.setCheckout(true);
            founded.setUser(user);
            return true;
        }
        return false;
    }

    public Movie findMovieWithIdentifier(Long identifier) {
        return movieRepository.findMovieWithIdentifier(identifier);
    }

    public List<String> listOfMoviesWithColumns() {
        return getListOfMovies().stream().filter(movie -> !movie.isCheckout())
                .map(Movie::toString).collect(Collectors.toList());
    }
}
