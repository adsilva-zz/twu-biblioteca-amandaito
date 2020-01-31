package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.User;

import java.util.List;

public interface UserRepository {

    public List<User> getListOfUsers();

    public User findUser(String libraryNumber);
}
