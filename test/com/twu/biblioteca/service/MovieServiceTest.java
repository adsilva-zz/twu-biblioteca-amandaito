package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.Rating;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.repository.MovieRepositoryImpl;
import com.twu.biblioteca.repository.UserRepository;
import com.twu.biblioteca.repository.UserRepositoryImpl;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MovieServiceTest {

    List<Movie> listOfMovies = new ArrayList<>();

    private UserRepository userRepository = new UserRepositoryImpl();

    private MovieRepository movieRepository = new MovieRepositoryImpl();

    private MovieService movieService = new MovieService(movieRepository);

    @Test
    public void getListOfMoviesWithSuccess() {
        Movie movie = new Movie("Guerra Mundial Z",
                LocalDate.of(2012, 1, 12), "Tom Testes", Rating.DEZ, false);

        listOfMovies.add(movie);

        assertEquals(1, movieService.getListOfMovies().size());
    }

    @Test
    public void getMovieRepositoryWithSuccess() {
        MovieRepository movieRep = movieService.getMovieRepository();
        assertNotNull(movieRep);
    }

    @Test
    public void checkoutMovieWithSuccess() {
        Movie founded = movieRepository.findMovieWithIdentifier((long)1);
        User user = userRepository.findUser("000-0001");
        movieService.checkoutMovie(founded.getIdentifier(), user);
        assertEquals(true, founded.isCheckout());
    }

    @Test
    public void verifyNumberOfMovieWithSuccess() {
        Movie movie = new Movie("Testes sucesso",
                LocalDate.of(2020, 1, 12), "Tom Testes", Rating.DEZ, false);

        movieService.getListOfMovies().add(movie);
        assertNotNull(movieService.findMovieWithIdentifier(movie.getIdentifier()));
    }
}
