package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.BibliotecaService;

import java.time.LocalDate;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaService mainService = new BibliotecaService();
        BookService bookService = new BookService();
        List<Book> listOfBooks = bookService.listOfBooks();
        Book bookTDD = new Book("Nora Roberts", "TDD", LocalDate.of(2019, 12, 27));
        Book bookDev = new Book("Jorge Amado", "Desenvolvimento", LocalDate.of(2018, 02, 17));
        listOfBooks.add(bookDev);
        listOfBooks.add(bookTDD);

        System.out.println(mainService.callWelcomeMessage());

        System.out.println("List of Books");
        listOfBooks.forEach(book -> System.out.println(book));
    }
}
