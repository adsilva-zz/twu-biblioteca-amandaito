package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.repository.BookRepositoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BibliotecaServiceTest {
    private List<Book> listOfBooks = new ArrayList<Book>();
    private BookRepositoryImpl bookRepository = new BookRepositoryImpl(listOfBooks);
    private BookService bookService = new BookService(bookRepository);
    private BibliotecaService bibliotecaService = new BibliotecaService(bookService);
    private MenuService menuService = new MenuService(bibliotecaService);

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
    public void listBooksWithAuthorAndPublication() {
        String dataBook = "1 | Nora Roberts | 2019-12-27";
        Book book = new Book("Nora Roberts", "TDD", LocalDate.of(2019, 12, 27), false);
        bookService.getListOfBooks().add(book);
        assertEquals(listOfBooks.size(), 1);
        assertEquals(dataBook, bibliotecaService.listBooksWithColumns(listOfBooks).get(0));
    }

    @Test
    public void showMessageCheckoutBookWithSuccess(){
        String successMessage = "Thank you! Enjoy the book";
        assertEquals(successMessage, bibliotecaService.getSUCCESS_CHECKOUT());
    }

    @Test
    public void showMessageCheckoutBookWithUn_Successful(){
        String successMessage = "Sorry, that book is not available";
        assertEquals(successMessage, bibliotecaService.getUN_SUCCESSFUL_CHECKOUT());
    }

    @Test
    public void showMessageReturnBookWithSuccess(){
        String successMessage = "Thank you for returning the book";
        assertEquals(successMessage, bibliotecaService.getSUCCESSFUL_RETURN());
    }

    @Test
    public void showMessageReturnBookWithUn_Success(){
        String successMessage = "That is not a valid book to return";
        assertEquals(successMessage, bibliotecaService.getUN_SUCCESSFUL_RETURN());
    }
}
