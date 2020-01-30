package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.repository.BookRepository;

import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getListOfBooks() {
        return bookRepository.getListOfBooks();
    }

    public void checkoutBook(Book book){
        book.setCheckout(true);
    }

    public Book findBookWithIdentifier(long identifier){
        return bookRepository.findBook(identifier);
    }

    public void returnBook(Book book){
        book.setCheckout(false);
    }
}
