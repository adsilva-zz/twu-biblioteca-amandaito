package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.model.UserType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final static List<User> listOfUsers = new ArrayList<>(Arrays.asList(
            new User("teste", "luiza", "lgmaraes2@gmail.com", "1234543422", UserType.CUSTOMER),
            new User("teste", "eliza", "testgmaraes2@gmail.com", "1234543422", UserType.LIBRARIAN)

    ));

    @Override
    public List<User> getListOfUsers() {
        return this.listOfUsers;
    }

    @Override
    public User findUser(String libraryNumber) {
        return getListOfUsers().stream()
                .filter(user -> user.getLibraryNumber().equals(libraryNumber)).findFirst().orElse(null);
    }


}
