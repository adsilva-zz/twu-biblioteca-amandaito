package com.twu.biblioteca;

import com.twu.biblioteca.model.*;
import com.twu.biblioteca.repository.*;
import com.twu.biblioteca.service.*;

import javax.jws.soap.SOAPBinding;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {

        BookRepository bookRepository = new BookRepositoryImpl();
        BookService bookService = new BookService(bookRepository);

        MovieRepository movieRepository = new MovieRepositoryImpl();
        MovieService movieService = new MovieService(movieRepository);

        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserService(userRepository);

        BibliotecaService bibliotecaService = new BibliotecaService(bookService, movieService, userService);
        MenuService menuService = new MenuService(bibliotecaService, userService);

        System.out.println(menuService.callWelcomeMessage());

        System.out.println(menuService.listMenuOptions());

        int option = 0;

        while (option != 7) {
            option = menuService.chooseMenuOption();

            if (option == 1) {
                bibliotecaService.listBooksWithColumns().forEach(System.out::println);
            } else if (option == 2) {
                bibliotecaService.listOfMoviesWithColumns().forEach(System.out::println);
            } else if (option == 3) {
                menuService.interactionToLogin();
                if (menuService.getUser() == null) {
                    System.out.println("Library number or password wrong");
                }else {
                    menuService.interactionToCheckoutBook();
                }
            } else if (option == 4) {
                menuService.interactionToLogin();
                if (menuService.getUser() == null) {
                    System.out.println("Library number or password wrong");
                }else {
                    menuService.interactionToReturnBook();
                }
            } else if (option == 5) {
                menuService.interactionToCheckoutMovie();
            }else if (option == 6) {
                if (menuService.getUser() == null) {
                    System.out.println("Option available to users logged");
                }else {
                    System.out.println(bibliotecaService.showUserInformation(menuService.getUser().getLibraryNumber()));;
                }
            } else if (option != 7) {
                System.out.println("Please select valid option");
            }
        }

    }
}
