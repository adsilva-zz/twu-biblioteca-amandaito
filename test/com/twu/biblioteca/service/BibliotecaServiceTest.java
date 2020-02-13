package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repository.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaServiceTest {

    private UserRepository userRepository;
    private MovieRepository movieRepository;
    private BookRepository bookRepository;
    private BookService bookService;
    private MovieService movieService;
    private UserService userService;
    private BibliotecaService bibliotecaService;

    @Before
    public void setup() {

        bookRepository = new BookRepositoryImpl();
        bookService = new BookService(bookRepository);

        movieRepository = new MovieRepositoryImpl();

        movieService = new MovieService(movieRepository);
        userRepository = new UserRepositoryImpl();
        userService = new UserService(userRepository);

        bibliotecaService = new BibliotecaService(bookService, movieService, userService);
    }


    @Test
    public void listBooksWithColumns() {
        String dataBook = "1 | Testes Unitários | Nora Roberts | 2019-12-27";

        assertEquals(bookService.getListOfBooks().size(), 2);
        assertEquals(dataBook, bibliotecaService.listBooksWithColumns().get(0));
    }

    @Test
    public void listMoviesWithColumns() {
        String dataMovie = "1 | Guerra Mundial Z | Tom Testes | 2020-01-12 | DEZ";

        assertEquals(movieService.getListOfMovies().size(), 1);
        String s = bibliotecaService.listOfMoviesWithColumns().get(0);

        assertEquals(dataMovie, bibliotecaService.listOfMoviesWithColumns().get(0));
    }

    @Test
    public void listBooksCheckedWithSuccess() {
        String expected = "luiza - 1 | Testes Unitários | Nora Roberts | 2019-12-27";
        User user = userRepository.findUser("000-0001");
        Book book = bookService.findBookWithIdentifier((long) 1);

        bibliotecaService.checkoutBook(book.getIdentifier(), user);

        boolean contains = bibliotecaService.listOfBooksChecked().contains(expected);

        assertTrue(contains);
    }

    @Test
    public void showUserInformation() {
        String expected = "000-0001 luiza | lgmaraes2@gmail.com | 1234543422";

        assertEquals(expected, bibliotecaService.showUserInformation("000-0001"));

    }

    @Test
    public void showUserInformationWithFailed() {
        String expected = "Not found user.";

        assertEquals(expected, bibliotecaService.showUserInformation("000-0012"));
    }

    @Test
    public void checkoutBookWithSuccess() {
        User user = userRepository.findUser("000-0001");
        boolean checkoutBook = bibliotecaService.checkoutBook((long) 1, user);

        assertTrue(checkoutBook);
    }

    @Test
    public void checkoutBookWithFailed() {
        User user = userRepository.findUser("000-0001");
        boolean checkoutBook = bibliotecaService.checkoutBook((long) 4, user);

        assertFalse(checkoutBook);
    }

    @Test
    public void checkoutBookWithUserFailed() {
        User user = userRepository.findUser("000-0020");
        boolean checkoutBook = bibliotecaService.checkoutBook((long) 1, user);

        assertFalse(checkoutBook);
    }

    @Test
    public void checkoutMovieWithSuccess() {
        User user = userRepository.findUser("000-0001");
        boolean checkoutMovie = bibliotecaService.checkoutMovie((long) 1, user);

        assertTrue(checkoutMovie);
    }

    @Test
    public void checkoutMovieWithFailed() {
        User user = userRepository.findUser("000-0001");
        boolean checkoutMovie = bibliotecaService.checkoutMovie((long) 4, user);

        assertFalse(checkoutMovie);
    }

    @Test
    public void checkoutMovieWithUserFailed() {
        User user = userRepository.findUser("000-0020");
        boolean checkoutMovie = bibliotecaService.checkoutMovie((long) 1, user);

        assertFalse(checkoutMovie);
    }

    @Test
    public void returnBookWithSuccess() {
       bibliotecaService.checkoutBook(1l, userRepository.findUser("000-0001"));
        boolean returnBook = bibliotecaService.returnBook(1l);
        assertTrue(returnBook);
    }

    @Test
    public void returnBookWithNotFound() {
        bibliotecaService.checkoutBook(3l, userRepository.findUser("000-0001"));
        boolean returnBook = bibliotecaService.returnBook(1l);
        assertFalse(returnBook);
    }
}
