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

    public Book findBook(Long numberOfBook) {
        return this.bookService.findBookWithIdentifier(numberOfBook);
    }

    public Movie findMovieWithIdentifier(Long movieNumber) {
        return this.movieService.findBookWithIdentifier(movieNumber);
    }

    public List<Book> getListOfBooks() {
        return this.bookService.getListOfBooks();
    }

    public List<Movie> getListOfMovies(){return this.movieService.getListOfMovies();}

}
