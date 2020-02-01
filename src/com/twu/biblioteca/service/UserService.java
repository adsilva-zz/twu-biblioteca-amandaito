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

    public User login(String password, String librarianNumber){
        User user = userRepository.findUser(librarianNumber);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    public User findUser(String libraryNumber) {
        return userRepository.findUser(libraryNumber);
    }
}
