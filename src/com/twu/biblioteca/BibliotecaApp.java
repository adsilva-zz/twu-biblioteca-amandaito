package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.BibliotecaService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaService bibliotecaService = new BibliotecaService();
        BookRepository bookRepository = new BookRepository();
        BookService bookService = new BookService(bookRepository);
        List<Book> listOfBooks = bookService.getlistOfBooks();
        Book bookTDD = new Book("Nora Roberts", "TDD", LocalDate.of(2019, 12, 27));
        Book bookDev = new Book("Jorge Amado", "Desenvolvimento", LocalDate.of(2018, 02, 17));
        listOfBooks.add(bookDev);
        listOfBooks.add(bookTDD);

        System.out.println(bibliotecaService.callWelcomeMessage());

        System.out.println(bibliotecaService.listMenuOptions());

        int option = 0;
        while (option != 2) {
            option = bibliotecaService.chooseMenuOption();
            if (option == 1) {
                bibliotecaService.listBooksWithColumns(listOfBooks).forEach(book -> System.out.println(book));
            } else if (option == 2){
                System.out.println("Please select valid option");
            }
        }
    }
}
