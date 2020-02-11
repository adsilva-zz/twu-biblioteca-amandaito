package com.twu.biblioteca;

import com.twu.biblioteca.repository.*;
import com.twu.biblioteca.service.*;

import java.util.InputMismatchException;

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

        System.out.println(userRepository.getListOfUsers());

        try {
            int option = 0;
            while (option != 8) {
                option = menuService.chooseMenuOption();

                if (option == 1) {
                    bibliotecaService.listBooksWithColumns().forEach(System.out::println);
                } else if (option == 2) {
                    bibliotecaService.listOfMoviesWithColumns().forEach(System.out::println);

                } else if (option == 3) {
                    menuService.interactionToCheckoutBook();

                } else if (option == 4) {
                    menuService.interactionToReturnBook();

                } else if (option == 5) {
                    menuService.interactionToCheckoutMovie();

                } else if (option == 6) {
                    menuService.interactionToViewInformation();

                } else if(option == 7){
                    menuService.interactionToMenuLibrarian();

                } else if (option != 7) {
                    System.out.println("Please select valid option");
                }
            }
        } catch (InputMismatchException e){
            System.out.println(MenuService.NUMBER_ONLY);
        }
    }
}
