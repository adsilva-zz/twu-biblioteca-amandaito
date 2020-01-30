package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.User;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private List<User> listOfUsers;

    public UserRepositoryImpl(List<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    @Override
    public User showInformationUser(long identifier) {
        return null;
    }

    @Override
    public List<User> getListOfUsers() {
        return this.listOfUsers;
    }


}
