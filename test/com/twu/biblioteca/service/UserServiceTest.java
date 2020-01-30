package com.twu.biblioteca.service;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.model.UserType;
import com.twu.biblioteca.repository.UserRepository;
import com.twu.biblioteca.repository.UserRepositoryImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserServiceTest {

    private List<User> listOfUser = new ArrayList<>();
    private UserRepository userRepository = new UserRepositoryImpl(listOfUser);
    private UserService userService = new UserService(userRepository);


    @Test
    public void getListOfUsers(){
        assertNotNull(userService.getListOfUsers());
    }

    @Test
    public void loginWithSuccess(){
        User user = new User("teste", "luiza", "lgmaraes2@gmail.com", "1234543422", UserType.CUSTOMER);
        listOfUser.add(user);

        assertTrue(userService.login("teste", user.getLibraryNumber()));
    }
}
