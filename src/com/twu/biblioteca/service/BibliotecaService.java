package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BibliotecaService {

    private final String SUCCESS_CHECKOUT = "Thank you! Enjoy the book";
    private final String UN_SUCCESSFUL_CHECKOUT = "Sorry, that book is not available";
    private final String SUCCESSFUL_RETURN = "Thank you for returning the book";
    private final String UN_SUCCESSFUL_RETURN = "That is not a valid book to return";
    private BookService bookService;

    public BibliotecaService(BookService bookService) {
        this.bookService = bookService;
    }

    public List<String> listBooksWithColumns(List<Book> listOfBooks) {
        return listOfBooks.stream().filter(book -> !book.isCheckout()).map(Book::toString).collect(Collectors.toList());
    }

    public void checkoutBook(Book book) {
        this.bookService.checkoutBook(book);
    }

    public void returnBook(Book book) {
        this.bookService.returnBook(book);
    }

    public Book findBookWithIdentifier(Long numberOfBook) {
        return this.bookService.findBookWithIdentifier(numberOfBook);
    }

    public List<Book> getListOfBooks() {
        return this.bookService.getListOfBooks();
    }

    public String getSUCCESS_CHECKOUT() {
        return this.SUCCESS_CHECKOUT;
    }

    public String getUN_SUCCESSFUL_CHECKOUT() {
        return this.UN_SUCCESSFUL_CHECKOUT;
    }

    public String getSUCCESSFUL_RETURN() {
        return this.SUCCESSFUL_RETURN;
    }

    public String getUN_SUCCESSFUL_RETURN(){
        return this.UN_SUCCESSFUL_RETURN;
    }
}
