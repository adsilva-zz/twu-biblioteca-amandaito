package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.repository.BookRepositoryImpl;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.BibliotecaService;
import com.twu.biblioteca.service.MenuService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        List<Book> listOfBooks = new ArrayList<>();
        BookRepositoryImpl bookRepository = new BookRepositoryImpl(listOfBooks);
        BookService bookService = new BookService(bookRepository);
        BibliotecaService bibliotecaService = new BibliotecaService(bookService);
        MenuService menuService = new MenuService(bibliotecaService);

        Book bookTDD = new Book("Nora Roberts", "Testes Unitários", LocalDate.of(2019, 12, 27), false);
        Book bookDev = new Book("Jorge Amado", "Desenvolvimento Web", LocalDate.of(2018, 2, 17), false);
        listOfBooks.add(bookDev);
        listOfBooks.add(bookTDD);

        System.out.println(menuService.callWelcomeMessage());

        System.out.println(menuService.listMenuOptions());

        int option = 0;

        while (option != 4) {
            option = menuService.chooseMenuOption();

            if (option == 1) {
                bibliotecaService.listBooksWithColumns(listOfBooks)
                        .forEach(System.out::println);
            } else if (option == 2) {
                menuService.interactionToCheckoutBook();
            } else if (option == 3) {
                menuService.interactionToReturnBook();
            } else if (option != 4){
                System.out.println("Please select valid option");
            }
        }

    }
}
