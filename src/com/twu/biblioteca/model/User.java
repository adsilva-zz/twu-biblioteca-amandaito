package com.twu.biblioteca.model;

import java.time.format.DateTimeFormatter;

public class User {

    private Long libraryNumber;
    private static long SEQUENCE;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private UserType userType;

    public User(String password, String name, String email, String phoneNumber, UserType userType) {
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.libraryNumber = ++SEQUENCE;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return name + " | " + email +" | " + phoneNumber;
    }

}
