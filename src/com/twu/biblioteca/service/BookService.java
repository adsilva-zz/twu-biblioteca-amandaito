package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.repository.BookRepository;

import java.util.List;

public class BookService {

    private BookRepository bookRepository = new BookRepository();

    public List<Book> listOfBooks() {
        return bookRepository.getListOfBook();
    }
}
