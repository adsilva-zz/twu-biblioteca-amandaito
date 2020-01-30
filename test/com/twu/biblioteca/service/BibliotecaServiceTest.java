package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.repository.BookRepositoryImpl;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.repository.MovieRepositoryImpl;
import org.junit.After;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BibliotecaServiceTest {
    private List<Book> listOfBooks = new ArrayList<Book>();

    private BookRepositoryImpl bookRepository = new BookRepositoryImpl(listOfBooks);

    private BookService bookService = new BookService(bookRepository);

    private List<Movie> listOfMovies = new ArrayList<>();

    private MovieRepository movieRepository = new MovieRepositoryImpl(listOfMovies);

    private MovieService movieService = new MovieService(movieRepository);

    private BibliotecaService bibliotecaService = new BibliotecaService(bookService, movieService);

    @After
    public void finalize() {
        listOfBooks.clear();
    }

    @Test
    public void listBooksWithSuccess() {
        List<Book> listOfBooks = bibliotecaService.getListOfBooks();
        assertNotNull(listOfBooks);
    }

    @Test
    public void listMoviesWithSuccess() {
        List<Movie> listOfMovies = bibliotecaService.getListOfMovies();
        assertNotNull(listOfMovies);
    }

    @Test
    public void listBooksWithAuthorAndPublication() {
        String dataBook = "1 | TDD | Nora Roberts | 2019-12-27";
        Book book = new Book("Nora Roberts", "TDD",
                LocalDate.of(2019, 12, 27), false);

        bookService.getListOfBooks().add(book);

        assertEquals(listOfBooks.size(), 1);
        assertEquals(dataBook, bibliotecaService.listBooksWithColumns(listOfBooks).get(0));
    }
}
