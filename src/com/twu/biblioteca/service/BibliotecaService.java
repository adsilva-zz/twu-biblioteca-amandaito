package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BibliotecaService {

    private String welcomeMassage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
    private String menuOptions = "Menu \n1 - List of books\n2 - Checkout books \n3 - Quit";

    public String callWelcomeMessage() {
        return welcomeMassage;
    }

    public List<String> listBooksWithColumns(List<Book> listOfBooks) {
       return listOfBooks.stream().filter(book -> !book.isCheckout()).map(Book::toString).collect(Collectors.toList());
    }

    public String listMenuOptions(){
        return menuOptions;
    }

    public int chooseMenuOption(){
        Scanner read = new Scanner(System.in);
        int option;
        System.out.printf("Please choose an option: ");
        option = read.nextInt();
        return option;
    }
}
