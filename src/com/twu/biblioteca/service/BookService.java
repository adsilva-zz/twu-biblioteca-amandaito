package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getListOfBooks() {
        return bookRepository.getListOfBooks();
    }

    public void checkoutBook(Book book, User user){
        book.setUser(user);
        book.setCheckout(true);
    }

    public Book findBookWithIdentifier(long identifier){
        return bookRepository.findBook(identifier);
    }

    public void returnBook(Book book){
        book.setCheckout(false);
    }

    public List<String> listBooksWithColumns() {
        return getListOfBooks().stream().filter(book -> !book.isCheckout())
                .map(Book::toString).collect(Collectors.toList());
    }
}
