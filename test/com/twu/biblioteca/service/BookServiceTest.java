package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.model.UserType;
import com.twu.biblioteca.repository.BookRepositoryImpl;
import com.twu.biblioteca.repository.UserRepository;
import com.twu.biblioteca.repository.UserRepositoryImpl;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookRepositoryImpl bookRepository = new BookRepositoryImpl();
    private BookService bookService = new BookService(bookRepository);
    private UserRepository userRepository = new UserRepositoryImpl();

    @Test
    public void listBooksWithSuccess() {
        assertNotNull(bookService.getListOfBooks());
        assertTrue(bookService.getListOfBooks() instanceof List);
    }

    @Test
    public void checkoutBookWithSuccess() {
        Book book = bookRepository.findBook(1);
        book.setCheckout(false);
        User user = userRepository.findUser("000-0001");

        boolean checkoutBook = bookService.checkoutBook(book.getIdentifier(), user);
        assertEquals(true,checkoutBook );
    }

    @Test
    public void checkoutBookWithFailed(){
        Book book = bookRepository.findBook(1);
        book.setCheckout(true);
        User user = userRepository.findUser("000-0001");
        assertFalse(bookService.checkoutBook(book.getIdentifier(), user));
    }

    @Test
    public void bookHasUserAfterCheckout() {
        Book book = bookRepository.findBook(1);
        User user = userRepository.findUser("000-0001");
        bookService.checkoutBook(book.getIdentifier(), user);
        assertEquals(user, book.getUser());
    }

    @Test
    public void verifyNumberOfBookWithSuccess() {
        Book book = new Book("Bruce Lee", "Run two",
                LocalDate.of(2019, 02, 12), false);
        bookService.getListOfBooks().add(book);
        assertNotNull(bookService.findBookWithIdentifier(book.getIdentifier()));
    }

    @Test
    public void returnBookWithSuccess() {
        Book book = bookRepository.findBook(1);
        book.setCheckout(true);
        bookService.returnBook(book.getIdentifier());
        assertEquals(false, book.isCheckout());
    }
}
