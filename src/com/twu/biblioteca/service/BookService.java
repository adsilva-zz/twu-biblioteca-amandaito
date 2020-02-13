package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getListOfBooks() {
        return bookRepository.getListOfBooks();
    }

    public boolean checkoutBook(Long bookNumber, User user){
        Book founded = findBookWithIdentifier(bookNumber);

        if(founded != null && !founded.isCheckout() && user != null){
            founded.setUser(user);
            founded.setCheckout(true);
            return true;
        }
        return false;
    }

    public Book findBookWithIdentifier(long identifier){
        return bookRepository.findBook(identifier);
    }

    public boolean returnBook(Long bookNumber){
        Book founded = findBookWithIdentifier(bookNumber);

        if(founded != null && founded.isCheckout()){
            founded.setCheckout(false);
            founded.setUser(null);
            return true;
        }
        return false;
    }

    public List<String> listBooksWithColumns() {
        return getListOfBooks().stream().filter(book -> !book.isCheckout())
                .map(Book::toString).collect(Collectors.toList());
    }

    public List<String> listOfBooksChecked() {
        return getListOfBooks().stream().filter(book -> book.isCheckout())
                .map(Book::viewUserChecked).collect(Collectors.toList());
    }
}
