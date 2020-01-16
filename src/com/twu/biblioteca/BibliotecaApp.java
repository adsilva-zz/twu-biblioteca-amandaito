package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.MainService;

import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        MainService mainService = new MainService();
        BookService bookService = new BookService();
        List<Book> listOfBooks = bookService.listOfBooks();
        listOfBooks.add(new Book());
        listOfBooks.add(new Book());

        System.out.println(mainService.callWelcomeMessage());

        System.out.println("Lis of Books");
        listOfBooks.forEach(book->System.out.println(book));

    }
}
