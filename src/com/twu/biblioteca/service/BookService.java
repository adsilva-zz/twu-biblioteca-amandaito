package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.repository.BookRepositoryImpl;

import java.util.List;

public class BookService {

    private BookRepositoryImpl bookRepository;

    public BookService(BookRepositoryImpl bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getListOfBooks() {
        return bookRepository.getListOfBooks();
    }

    public void checkoutBook(Book book){
        book.setCheckout(true);
    }

    public Book findBookWithIdentifier(long identifier){
        return getListOfBooks().stream().filter(book -> book.getIdentifier() == identifier).findFirst().orElse(null);
    }
}
