package com.twu.biblioteca.service;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repository.UserRepository;
import com.twu.biblioteca.repository.UserRepositoryImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    private UserRepository userRepository = new UserRepositoryImpl();
    private UserService userService = new UserService(userRepository);

    @Test
    public void getListOfUsers() {
        assertNotNull(userService.getListOfUsers());
    }

    @Test
    public void loginWithSuccess() {
        User userLogin = userService.login("teste", "000-0001");
        assertNotNull(userLogin);
    }

    @Test
    public void loginWithIncorrectPassword() {

        assertNull(userService.login("  ", "000-0001"));
    }

    @Test
    public void loginWithIncorrectLibraryNumber() {

        assertNull(userService.login("teste", " tttt "));
    }

    @Test
    public void findUserWithSuccess() {
        User userFound = userService.findUser("000-0001");
        assertEquals("000-0001", userFound.getLibraryNumber());
    }
}
