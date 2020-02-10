package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;

import java.util.Scanner;

public class MenuService {

    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";

    private static final String MENU_OPTIONS = "Menu\n1 - List of books\n2 - List of movies\n3 - Checkout book \n4 - Return book " +
            "\n5 - Checkout Movie \n6 - Quit";

    private static final String CHOOSE_OPTION = "Please choose an option: ";

    private static final String CHOOSE_BOOK = "Entry with number: ";

    private static final String ENTRY_LIBRARY_NUMBER = "Entry with your library number: ";

    private static final String ENTRY_LIBRARY_PASSWORD = "Entry with your password: ";

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

    public void setUser(User user) {
        this.user = user;
    }

    public String callWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public String listMenuOptions() {
        return MENU_OPTIONS;
    }

    public int chooseMenuOption() {
        Scanner read = new Scanner(System.in);
        int option;

        System.out.printf(CHOOSE_OPTION);
        option = read.nextInt();

        return option;
    }

    public long choose() {
        Scanner read = new Scanner(System.in);
        int identifierBook;

        System.out.printf(CHOOSE_BOOK);
        identifierBook = read.nextInt();

        return identifierBook;
    }

    public void interactionToCheckoutBook(){
        long bookNumber = this.choose();
        Book bookFound = bibliotecaService.findBook(bookNumber);

        if (bookFound != null && !bookFound.isCheckout()) {
            bibliotecaService.checkoutBook(bookFound, user);
            System.out.println(bibliotecaService.SUCCESS_CHECKOUT_BOOK);
        } else {
            System.out.println(bibliotecaService.UN_SUCCESSFUL_CHECKOUT_BOOK);
        }
    }

    public void interactionToReturnBook(){
        long bookNumber = this.choose();
        Book bookFound = bibliotecaService.findBook(bookNumber);

        if (bookFound != null && bookFound.isCheckout()) {
            bibliotecaService.returnBook(bookFound);
            System.out.println(bibliotecaService.SUCCESSFUL_RETURN_BOOK);
        }else {
            System.out.println(bibliotecaService.UN_SUCCESSFUL_RETURN_BOOK);
        }
    }

    public void interactionToCheckoutMovie(){
        long movieNumber = this.choose();
        Movie movieFound = bibliotecaService.findMovie(movieNumber);

        if (movieFound != null && !movieFound.isCheckout()) {
            bibliotecaService.checkoutMovie(movieFound);
            System.out.println(bibliotecaService.SUCCESS_CHECKOUT_MOVIE);
        } else {
            System.out.println(bibliotecaService.UN_SUCCESSFUL_CHECKOUT_MOVIE);
        }
    }

    public void interactionToLogin(){
        Scanner read = new Scanner(System.in);

        String libraryNumber;
        String password;

        System.out.println(ENTRY_LIBRARY_NUMBER);
        libraryNumber=read.nextLine();

        System.out.println(ENTRY_LIBRARY_PASSWORD);
        password = read.nextLine();

        this.user = userService.login(password, libraryNumber);
    }
}
