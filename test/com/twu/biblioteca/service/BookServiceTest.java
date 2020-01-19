package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService = new BookService();

    @Test
    public void listBooksWithSuccess() {
        assertNotNull(bookService.listOfBooks());
        assertTrue(bookService.listOfBooks() instanceof List);
    }
}
