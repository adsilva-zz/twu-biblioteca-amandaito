package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.Rating;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieRepositoryImpl implements MovieRepository {

    private final List<Movie> listOfMovies = new ArrayList<>(Arrays.asList(
            new Movie(1L, "Guerra Mundial Z", LocalDate.of(2020, 1, 12), "Tom Testes",
                    Rating.DEZ, false )));

    @Override
    public List<Movie> getListOfMovies() {
        return listOfMovies;
    }

    @Override
    public Movie findMovieWithIdentifier(Long identifier){
        return getListOfMovies().stream().filter(movie -> movie.getIdentifier().equals(identifier))
                .findFirst().orElse(null);
    }

}
