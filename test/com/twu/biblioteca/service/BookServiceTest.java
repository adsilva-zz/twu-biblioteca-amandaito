package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.repository.BookRepository;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookRepository bookRepository = new BookRepository();
    private BookService bookService = new BookService(bookRepository);

    @Test
    public void listBooksWithSuccess() {
        assertNotNull(bookService.getListOfBooks());
        assertTrue(bookService.getListOfBooks() instanceof List);
    }

    @Test
    public void checkoutBookWithSuccess(){
        Book book = new Book("Bruce Lee", "Run two", LocalDate.of(2019, 02, 12), false);
        bookService.checkoutBook(book);
        assertEquals(true, book.isCheckout());
    }

    public void verifyNumberOfBookWithSuccess(){
        List<Book> listOfBooks = bookService.getListOfBooks();
        Book book = new Book("Bruce Lee", "Run two", LocalDate.of(2019, 02, 12), false);
        listOfBooks.add(book);
        assertNotNull(bookService.findBookWithIdentifier(1));
    }
}
