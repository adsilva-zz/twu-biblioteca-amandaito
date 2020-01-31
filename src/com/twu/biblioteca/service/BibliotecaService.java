package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class BibliotecaService {

    public final String SUCCESS_CHECKOUT_BOOK = "Thank you! Enjoy the book";
    public final String UN_SUCCESSFUL_CHECKOUT_BOOK = "Sorry, that book is not available";
    public final String SUCCESSFUL_RETURN_BOOK = "Thank you for returning the book";
    public final String UN_SUCCESSFUL_RETURN_BOOK = "That is not a valid book to return";

    public final String SUCCESS_CHECKOUT_MOVIE = "Thank you! Enjoy the movie";
    public final String UN_SUCCESSFUL_CHECKOUT_MOVIE = "Sorry, that movie is not available";

    private BookService bookService;
    private MovieService movieService;

    public BibliotecaService(BookService bookService, MovieService movieService) {
        this.bookService = bookService;
        this.movieService = movieService;
    }

    public List<String> listBooksWithColumns() {
        return bookService.listBooksWithColumns();
    }

    public List<String> listOfMoviesWithColumns() {
        return movieService.listOfMoviesWithColumns();
    }

    public void checkoutBook(Book book) {
        bookService.checkoutBook(book);
    }

    public void checkoutMovie(Movie movie) { movieService.checkoutMovie(movie);
    }

    public void returnBook(Book book) {
        bookService.returnBook(book);
    }

    public Book findBook(Long numberOfBook) {
        return bookService.findBookWithIdentifier(numberOfBook);
    }

    public Movie findMovie(Long movieNumber) {
        return movieService.findBookWithIdentifier(movieNumber);
    }

}
