package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.model.UserType;
import com.twu.biblioteca.repository.BookRepositoryImpl;
import org.junit.After;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {
    private List<Book> listOfBooks = new ArrayList<Book>();
    private BookRepositoryImpl bookRepository = new BookRepositoryImpl(listOfBooks);
    private BookService bookService = new BookService(bookRepository);

    @After
    public void finalize() {
        listOfBooks.clear();
    }

    @Test
    public void listBooksWithSuccess() {
        assertNotNull(bookService.getListOfBooks());
        assertTrue(bookService.getListOfBooks() instanceof List);
    }

    @Test
    public void checkoutBookWithSuccess(){
        Book book = new Book("Bruce Lee", "Run two",
                LocalDate.of(2019, 02, 12), false);

        User user = new User("teste", "luiza", "lgmaraes2@gmail.com",
                "1234543422", UserType.CUSTOMER);

        bookService.checkoutBook(book, user);
        assertEquals(true, book.isCheckout());
    }

    @Test
    public void bookHasUserAfterCheckout(){
        Book book = new Book("Bruce Lee", "Run two",
                LocalDate.of(2019, 02, 12), false);

        User user = new User("teste", "luiza", "lgmaraes2@gmail.com",
                "1234543422", UserType.CUSTOMER);

        bookService.checkoutBook(book, user);
        assertEquals(user, book.getUser());
    }

    @Test
    public void verifyNumberOfBookWithSuccess(){
        Book book = new Book("Bruce Lee", "Run two",
                LocalDate.of(2019, 02, 12), false);
        bookService.getListOfBooks().add(book);
        assertNotNull(bookService.findBookWithIdentifier(book.getIdentifier()));
    }

    @Test
    public void returnBookWithSuccess(){
        Book book = new Book("Bruce Lee", "Run two",
                LocalDate.of(2019, 02, 12), true);
        bookService.returnBook(book);
        assertEquals(false, book.isCheckout());
    }
}
