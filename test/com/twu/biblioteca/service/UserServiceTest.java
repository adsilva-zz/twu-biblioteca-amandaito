package com.twu.biblioteca.service;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.model.UserType;
import com.twu.biblioteca.repository.UserRepository;
import com.twu.biblioteca.repository.UserRepositoryImpl;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserServiceTest {

    private List<User> listOfUser = new ArrayList<>();
    private UserRepository userRepository = new UserRepositoryImpl(listOfUser);
    private UserService userService = new UserService(userRepository);

    @After
    public void finalize() {
        listOfUser.clear();
    }

    @Test
    public void getListOfUsers(){
        assertNotNull(userService.getListOfUsers());
    }

    @Test
    public void loginWithSuccess(){
        User user = new User("teste", "luiza", "lgmaraes2@gmail.com", "1234543422", UserType.CUSTOMER);
        listOfUser.add(user);
        User userLogin = userService.login(user.getPassword(), user.getLibraryNumber());
        assertEquals(userLogin, user);
    }

    @Test
    public void loginWithIncorrectPassword(){
        User user = new User("teste", "luiza", "lgmaraes2@gmail.com", "1234543422", UserType.CUSTOMER);
        listOfUser.add(user);
        assertNull(userService.login("  ", user.getLibraryNumber() ));
    }

    @Test
    public void loginWithIncorrectLibraryNumber(){
        User user = new User("teste", "luiza", "lgmaraes2@gmail.com", "1234543422", UserType.CUSTOMER);
        listOfUser.add(user);
        assertNull(userService.login(user.getPassword(), " tttt "));
    }

    @Test
    public void findUserWithSuccess(){
        User user = new User("teste", "luiza", "lgmaraes2@gmail.com", "1234543422", UserType.CUSTOMER);
        listOfUser.add(user);

        User userFound = userService.findUser(user.getLibraryNumber());
        assertEquals(user.getLibraryNumber(), userFound.getLibraryNumber());
    }
}
