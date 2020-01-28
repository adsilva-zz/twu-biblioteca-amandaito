package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.BookRepositoryImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

import static org.junit.Assert.*;

public class MenuServiceTest {

    private List<Book> listOfBooks = new ArrayList<Book>();
    private BookRepository bookRepository = new BookRepositoryImpl(listOfBooks);
    private BookService bookService = new BookService(bookRepository);
    private BibliotecaService bibliotecaService = new BibliotecaService(bookService);
    private MenuService menuService = new MenuService(bibliotecaService);

    @Test
    public void welcomeSuccessTest() {
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore", menuService.callWelcomeMessage());
    }

    @Test
    public void showMenuOptions() {
        String menuOptions = "Menu \n1 - List of books\n2 - Checkout book \n3 - Return book \n4 - Quit";
        assertEquals(menuOptions, menuService.listMenuOptions());
    }
}
