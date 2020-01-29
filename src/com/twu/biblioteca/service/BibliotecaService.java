package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class BibliotecaService {

    private final String SUCCESS_CHECKOUT_BOOK = "Thank you! Enjoy the book";
    private final String UN_SUCCESSFUL_CHECKOUT_BOOK = "Sorry, that book is not available";
    private final String SUCCESSFUL_RETURN_BOOK = "Thank you for returning the book";
    private final String UN_SUCCESSFUL_RETURN_BOOK = "That is not a valid book to return";

    private final String SUCCESS_CHECKOUT_MOVIE = "Thank you! Enjoy the movie";
    private final String UN_SUCCESSFUL_CHECKOUT_MOVIE = "Sorry, that movie is not available";
    private final String SUCCESSFUL_RETURN_MOVIE = "Thank you for returning the movie";
    private final String UN_SUCCESSFUL_RETURN_MOVIE = "That is not a valid movie to return";

    private BookService bookService;
    private MovieService movieService;

    public BibliotecaService(BookService bookService, MovieService movieService) {
        this.bookService = bookService;
        this.movieService = movieService;
    }

    public List<String> listBooksWithColumns(List<Book> listOfBooks) {
        return listOfBooks.stream().filter(book -> !book.isCheckout())
                .map(Book::toString).collect(Collectors.toList());
    }

    public List<String> listOfMovies(List<Movie> listOfMovies) {
        return listOfMovies.stream().filter(movie -> !movie.isCheckout())
                .map(Movie::toString).collect(Collectors.toList());
    }

    public void checkoutBook(Book book) {
        this.bookService.checkoutBook(book);
    }

    public void checkoutMovie(Movie movie) {
        this.movieService.checkoutMovie(movie);
    }

    public void returnBook(Book book) {
        this.bookService.returnBook(book);
    }

    public Book findBookWithIdentifier(Long numberOfBook) {
        return this.bookService.findBookWithIdentifier(numberOfBook);
    }

    public Movie findMovieWithIdentifier(Long movieNumber) {
        return this.movieService.findBookWithIdentifier(movieNumber);
    }

    public List<Book> getListOfBooks() {
        return this.bookService.getListOfBooks();
    }

    public List<Movie> getListOfMovies(){return this.movieService.getListOfMovies();}

    public String getSUCCESS_CHECKOUT_BOOK() {
        return this.SUCCESS_CHECKOUT_BOOK;
    }

    public String getUN_SUCCESSFUL_CHECKOUT_BOOK() {
        return this.UN_SUCCESSFUL_CHECKOUT_BOOK;
    }

    public String getSUCCESSFUL_RETURN_BOOK() {
        return this.SUCCESSFUL_RETURN_BOOK;
    }

    public String getUN_SUCCESSFUL_RETURN_BOOK(){
        return this.UN_SUCCESSFUL_RETURN_BOOK;
    }

    public String getSUCCESS_CHECKOUT_MOVIE() {
        return SUCCESS_CHECKOUT_MOVIE;
    }

    public String getUN_SUCCESSFUL_CHECKOUT_MOVIE() {
        return UN_SUCCESSFUL_CHECKOUT_MOVIE;
    }

    public String getSUCCESSFUL_RETURN_MOVIE() {
        return SUCCESSFUL_RETURN_MOVIE;
    }

    public String getUN_SUCCESSFUL_RETURN_MOVIE() {
        return UN_SUCCESSFUL_RETURN_MOVIE;
    }
}
