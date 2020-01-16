package com.twu.biblioteca.service;

import com.twu.biblioteca.BibliotecaApp;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService = new BookService();

    @Test
    public void listBooksWithSuccess(){
        assertNotNull(bookService.listOfBooks());
    }
}
