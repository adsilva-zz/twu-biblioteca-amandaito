package com.twu.biblioteca.service;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repository.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getListOfUsers(){
        return this.userRepository.getListOfUsers();
    }
}
