package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.User;

import java.util.List;

public interface UserRepository {

    public User showInformationUser(long identifier);

    public List<User> getListOfUsers();
}
