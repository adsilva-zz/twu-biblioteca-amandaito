package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Book;

import java.util.List;

public interface BookRepository {

    public List<Book> getListOfBooks();

    public Book findBook(long identifier);
}
