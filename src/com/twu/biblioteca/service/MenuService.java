package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.model.UserType;

import java.util.Scanner;

public class MenuService {

    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";

    private static final String MENU_OPTIONS = " - Menu of Biblioteca - " +
            "\n1 - List of books " +
            "\n2 - List of movies \n3 - Checkout book \n4 - Return book " +
            "\n5 - Checkout Movie \n6 - View my information \n7 - Librarian Menu \n8 - Quit";

    private static final String CHOOSE_OPTION = "Please choose an option: ";

    private static final String CHOOSE_NUMBER = "Entry with number: ";

    private static final String ENTRY_LIBRARY_NUMBER = "Entry with your library number: ";

    private static final String ENTRY_LIBRARY_PASSWORD = "Entry with your password: ";

    public static final String NUMBER_ONLY = "Only numbers allowed. ";

    private Scanner read = new Scanner(System.in);

    private BibliotecaService bibliotecaService;

    private User user;

    private UserService userService;

    public MenuService(BibliotecaService bibliotecaService, UserService userService) {
        this.bibliotecaService = bibliotecaService;
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }

    public String callWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public String listMenuOptions() {
        return MENU_OPTIONS;
    }

    public int chooseMenuOption() {

        System.out.printf(CHOOSE_OPTION);
        int option = read.nextInt();

        return option;
    }

    public int choose() {

        System.out.printf(CHOOSE_NUMBER);
        int identifierBook = read.nextInt();

        return identifierBook;
    }

    public void interactionToCheckoutBook() {
        interactionToLogin();
        if (getUser() == null) {
            System.out.println("Library number or password wrong");
        } else {
            if (bibliotecaService.checkoutBook((long) this.choose(), user)) {
                System.out.println(bibliotecaService.SUCCESS_CHECKOUT_BOOK);
            } else {
                System.out.println(bibliotecaService.UN_SUCCESSFUL_CHECKOUT_BOOK);
            }
        }
    }

    public void interactionToReturnBook() {
        interactionToLogin();
        if (getUser() == null) {
            System.out.println("Library number or password wrong");
        } else {
            if (bibliotecaService.returnBook((long)this.choose())) {
                System.out.println(bibliotecaService.SUCCESSFUL_RETURN_BOOK);
            } else {
                System.out.println(bibliotecaService.UN_SUCCESSFUL_RETURN_BOOK);
            }
        }
    }

    public void interactionToCheckoutMovie() {
        interactionToLogin();

        if (getUser() == null) {
            System.out.println("Library number or password wrong");
        } else {
            long movieNumber = this.choose();
            if (bibliotecaService.checkoutMovie((long)this.choose(), user)) {
                System.out.println(bibliotecaService.SUCCESS_CHECKOUT_MOVIE);
            } else {
                System.out.println(bibliotecaService.UN_SUCCESSFUL_CHECKOUT_MOVIE);
            }
        }
    }

    public void interactionToLogin() {
        Scanner read = new Scanner(System.in);

        System.out.println(ENTRY_LIBRARY_NUMBER);
        String libraryNumber = read.nextLine();

        System.out.println(ENTRY_LIBRARY_PASSWORD);
        String password = read.nextLine();

        this.user = userService.login(password, libraryNumber);
    }

    public void interactionToViewInformation() {
        interactionToLogin();
        if (getUser() == null) {
            System.out.println("Option available to users logged");
        } else {
            System.out.println(bibliotecaService.showUserInformation(getUser().getLibraryNumber()));
        }
    }

    public void interactionToMenuLibrarian() {
        interactionToLogin();
        if (getUser() == null) {
            System.out.println("Library number or password wrong");
        }
        if( getUser().getUserType().equals(UserType.LIBRARIAN)){
                if (!bibliotecaService.listOfBooksChecked().isEmpty()){
                    bibliotecaService.listOfBooksChecked().forEach(System.out::println);
                }else {
                    System.out.println("Not exist book checked.");
                }
        }else {
            System.out.println("This option only available for Librarian.");
        }

    }
}
