package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.BookRepositoryImpl;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.repository.MovieRepositoryImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MenuServiceTest {

    private List<Book> listOfBooks = new ArrayList<Book>();
    private BookRepository bookRepository = new BookRepositoryImpl(listOfBooks);
    private BookService bookService = new BookService(bookRepository);
    private List<Movie> listOfMovies = new ArrayList<>();
    private MovieRepository movieRepository = new MovieRepositoryImpl(listOfMovies);
    private MovieService movieService = new MovieService(movieRepository);
    private BibliotecaService bibliotecaService = new BibliotecaService(bookService, movieService);
    private MenuService menuService = new MenuService(bibliotecaService);

    @Test
    public void welcomeSuccessTest() {
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore",
                menuService.callWelcomeMessage());
    }

    @Test
    public void showMenuOptions() {
        String menuOptions = "Menu\n1 - List of books\n2 - List of movies\n3 - Checkout book \n4 - Return book " +
                "\n5 - Checkout Movie \n6 - Quit";
        assertEquals(menuOptions, menuService.listMenuOptions());
    }
}
