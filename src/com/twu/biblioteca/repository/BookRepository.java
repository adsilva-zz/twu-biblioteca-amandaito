package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private List<Book> listOfBook = new ArrayList<>();

    public BookRepository() {
    }

    public BookRepository(List<Book> listOfBook) {
        this.listOfBook = listOfBook;
    }

    public List<Book> getListOfBook() {
        return listOfBook;
    }

    public void setListOfBook(List<Book> listOfBook) {
        this.listOfBook = listOfBook;
    }
}
