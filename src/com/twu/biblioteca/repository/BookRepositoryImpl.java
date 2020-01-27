package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository{

    private List<Book> listOfBook;

    public BookRepositoryImpl(List<Book> listOfBook) {

        this.listOfBook = listOfBook;
    }

    @Override
    public List<Book> getListOfBooks() {
        return this.listOfBook;
    }
}
