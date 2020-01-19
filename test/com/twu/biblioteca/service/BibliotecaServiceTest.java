package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class BibliotecaServiceTest {

    private BibliotecaService bibliotecaService = new BibliotecaService();
    private BookService bookService = new BookService();

    @Test
    public void welcomeSuccessTest() {
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore", bibliotecaService.callWelcomeMessage());
    }

    @Test
    public void listBooksWithAuthorAndPublication() {
        String dataBook = "Nora Roberts | 2019-12-27";
        List<Book> listOfBooks = bookService.listOfBooks();
        Book book = new Book("Nora Roberts", "TDD", LocalDate.of(2019, 12, 27));
        assertNotNull(listOfBooks);
        listOfBooks.add(book);
        assertTrue(listOfBooks.size() == 1);
        assertEquals(dataBook, bibliotecaService.listBooksWithColumns(listOfBooks).get(0));
    }

    @Test
    public void showMenuOptions(){
        String menuOptions = "Menu \n 1 - List of books\n";
        assertEquals(menuOptions, bibliotecaService.listMenuOptions());
    }

}
