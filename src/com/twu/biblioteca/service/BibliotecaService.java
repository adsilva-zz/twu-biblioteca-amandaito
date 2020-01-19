package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BibliotecaService {

    private String welcomeMassage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";

    public String callWelcomeMessage() {
        return welcomeMassage;
    }

    public List<String> listBooksWithColumns(List<Book> listOfBooks) {
       return listOfBooks.stream().map(Book::toString).collect(Collectors.toList());
    }

    public String listMenuOptions(){
        return "Menu /n 1 - List of books";
    }
}
