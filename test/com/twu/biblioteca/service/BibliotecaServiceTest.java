package com.twu.biblioteca.service;

import com.twu.biblioteca.repository.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaServiceTest {

    private BookRepository bookRepository = new BookRepositoryImpl();

    private BookService bookService = new BookService(bookRepository);

    private MovieRepository movieRepository = new MovieRepositoryImpl();

    private MovieService movieService = new MovieService(movieRepository);

    private UserRepository userRepository = new UserRepositoryImpl();
    private UserService userService = new UserService(userRepository);

    private BibliotecaService bibliotecaService = new BibliotecaService(bookService, movieService, userService);


    @Test
    public void listBooksWithColumns() {
        String dataBook = "1 | Testes Unitários | Nora Roberts | 2019-12-27";

        assertEquals(bookService.getListOfBooks().size(), 2);
        assertEquals(dataBook, bibliotecaService.listBooksWithColumns().get(0));
    }

    @Test
    public void listMoviesWithColumns() {
        String dataMovie = "1 | Guerra Mundial Z | Tom Testes | 2020-01-12 | DEZ";

        assertEquals(movieService.getListOfMovies().size(), 1);
        assertEquals(dataMovie, bibliotecaService.listOfMoviesWithColumns().get(0));
    }
}
