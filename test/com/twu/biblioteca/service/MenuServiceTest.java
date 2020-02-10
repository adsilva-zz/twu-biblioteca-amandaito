package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repository.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MenuServiceTest {
    private BookRepository bookRepository = new BookRepositoryImpl();
    private BookService bookService = new BookService(bookRepository);
    private List<Movie> listOfMovies = new ArrayList<>();
    private MovieRepository movieRepository = new MovieRepositoryImpl(listOfMovies);
    private MovieService movieService = new MovieService(movieRepository);

    private List<User> listOfUsers = new ArrayList<>();
    private UserRepository userRepository = new UserRepositoryImpl(listOfUsers);
    private UserService userService = new UserService(userRepository);
    private BibliotecaService bibliotecaService = new BibliotecaService(bookService, movieService, userService);
    private MenuService menuService = new MenuService(bibliotecaService, userService);

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
