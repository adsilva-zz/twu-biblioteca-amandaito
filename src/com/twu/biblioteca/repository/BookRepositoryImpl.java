package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookRepositoryImpl implements BookRepository{

    private static List<Book> listOfBook = new ArrayList<>(Arrays.asList(
            new Book("Nora Roberts", "Testes Unitários", LocalDate.of(2019, 12, 27), false),
            new Book("Jorge Amado", "Desenvolvimento Web", LocalDate.of(2018, 2, 17), false)
    ));

    @Override
    public List<Book> getListOfBooks() {
        return this.listOfBook;
    }

    @Override
    public Book findBook(long identifier){
        return getListOfBooks().stream()
                .filter(book -> book.getIdentifier().equals(identifier)).findFirst().orElse(null);
    }
}
