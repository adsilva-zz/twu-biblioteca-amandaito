package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BibliotecaService {

    private final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
    private final String MENU_OPTIONS = "Menu \n1 - List of books\n2 - Checkout books \n3 - Quit";
    private final String CHOOSE_OPTION = "Please choose an option: ";
    private final String CHOOSE_BOOK = "Entry with book number: ";
    private BookService bookService;

    public BibliotecaService(BookService bookService){
        this.bookService = bookService;
    }

    public String callWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public List<String> listBooksWithColumns(List<Book> listOfBooks) {
       return listOfBooks.stream().filter(book -> !book.isCheckout()).map(Book::toString).collect(Collectors.toList());
    }

    public String listMenuOptions(){
        return MENU_OPTIONS;
    }

    public int chooseMenuOption(){
        Scanner read = new Scanner(System.in);
        int option;
        System.out.printf(CHOOSE_OPTION);
        option = read.nextInt();
        return option;
    }

    public long chooseBookToCheckout(){
        Scanner read = new Scanner(System.in);
        int identifierBook;
        System.out.printf(CHOOSE_BOOK);
        identifierBook = read.nextInt();
        return identifierBook;
    }

    public void checkoutBook(Book book){
        this.bookService.checkoutBook(book);
    }

    public Book findBookWithIdentifier(Long numberOfBook){
        return this.bookService.findBookWithIdentifier(numberOfBook);
    }

    public List<Book> getListOfBooks(){
        return this.bookService.getListOfBooks();
    }
}
