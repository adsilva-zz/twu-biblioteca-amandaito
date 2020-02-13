package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;

import java.util.List;

public class BibliotecaService {

    public static final String SUCCESS_CHECKOUT_BOOK = "Thank you! Enjoy the book";
    public static final String UN_SUCCESSFUL_CHECKOUT_BOOK = "Sorry, that book is not available";
    public static final String SUCCESSFUL_RETURN_BOOK = "Thank you for returning the book";
    public static final String UN_SUCCESSFUL_RETURN_BOOK = "That is not a valid book to return";

    public static final String SUCCESS_CHECKOUT_MOVIE = "Thank you! Enjoy the movie";
    public static final String UN_SUCCESSFUL_CHECKOUT_MOVIE = "Sorry, that movie is not available";

    public static final String USER_NOT_FOUND = "Not found user.";

    private UserService userService;

    private BookService bookService;
    private MovieService movieService;

    public BibliotecaService(BookService bookService, MovieService movieService, UserService userService) {
        this.bookService = bookService;
        this.movieService = movieService;
        this.userService = userService;
    }

    public List<String> listBooksWithColumns() {
        return bookService.listBooksWithColumns();
    }

    public List<String> listOfMoviesWithColumns() {
        return movieService.listOfMoviesWithColumns();
    }

    public List<String> listOfBooksChecked(){
        return bookService.listOfBooksChecked();
    }

    public String showUserInformation(String libraryNumber){
        User userFound = userService.findUser(libraryNumber);
        if (userFound != null){
            return userFound.toString();
        }
        return USER_NOT_FOUND;
    }

    public boolean checkoutBook(Long bookNumber, User user) {
        return bookService.checkoutBook(bookNumber, user);
    }

    public boolean checkoutMovie(Long movieNumber, User user) {
        return movieService.checkoutMovie(movieNumber, user);
    }

    public boolean returnBook(Long book) {
        return bookService.returnBook(book);
    }

}
