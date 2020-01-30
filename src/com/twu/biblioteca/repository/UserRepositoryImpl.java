package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.User;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private List<User> listOfUsers;

    public UserRepositoryImpl(List<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    @Override
    public List<User> getListOfUsers() {
        return this.listOfUsers;
    }

    @Override
    public User findUser(long libraryNumber) {
        return getListOfUsers().stream()
                .filter(user -> user.getLibraryNumber().equals(libraryNumber)).findFirst().orElse(null);
    }


}
