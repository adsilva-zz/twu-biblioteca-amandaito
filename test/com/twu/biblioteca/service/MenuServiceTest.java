package com.twu.biblioteca.service;

import com.twu.biblioteca.repository.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuServiceTest {
    private BookRepository bookRepository = new BookRepositoryImpl();
    private BookService bookService = new BookService(bookRepository);

    private MovieRepository movieRepository = new MovieRepositoryImpl();
    private MovieService movieService = new MovieService(movieRepository);

    private UserRepository userRepository = new UserRepositoryImpl();
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
