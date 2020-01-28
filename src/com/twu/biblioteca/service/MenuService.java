package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;

import java.util.Scanner;

public class MenuService {

    private final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
    private final String MENU_OPTIONS = "Menu \n1 - List of books\n2 - Checkout book \n3 - Return book \n4 - Quit";
    private final String CHOOSE_OPTION = "Please choose an option: ";
    private final String CHOOSE_BOOK = "Entry with book number: ";
    private BibliotecaService bibliotecaService;

    public MenuService(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
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

    public long chooseBook() {
        Scanner read = new Scanner(System.in);
        int identifierBook;

        System.out.printf(CHOOSE_BOOK);
        identifierBook = read.nextInt();

        return identifierBook;
    }

    public void interactionToCheckoutBook(){
        long bookNumber = this.chooseBook();
        Book bookFound = bibliotecaService.findBookWithIdentifier(bookNumber);

        if (bookFound != null && !bookFound.isCheckout()) {
            bibliotecaService.checkoutBook(bookFound);
            System.out.println(bibliotecaService.getSUCCESS_CHECKOUT());
        } else {
            System.out.println(bibliotecaService.getUN_SUCCESSFUL_CHECKOUT());
        }
    }

    public void interactionToReturnBook(){
        long bookNumber = this.chooseBook();
        Book bookFound = bibliotecaService.findBookWithIdentifier(bookNumber);

        if (bookFound != null && bookFound.isCheckout()) {
            bibliotecaService.returnBook(bookFound);
            System.out.println(bibliotecaService.getSUCCESSFUL_RETURN());
        }else {
            System.out.println(bibliotecaService.getUN_SUCCESSFUL_RETURN());
        }
    }
}
