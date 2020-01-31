package com.twu.biblioteca.model;

public class User {

    private String libraryNumber;
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
        this.libraryNumber = this.generateLibrarianNumber(++SEQUENCE);
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

    public String getLibraryNumber() {
        return libraryNumber;
    }

    @Override
    public String toString() {
        return name + " | " + email +" | " + phoneNumber;
    }

    private String generateLibrarianNumber(long sequence){
        String sequencePattern = String.format("%07d", sequence);

        StringBuilder numberLibrary = new StringBuilder(sequencePattern)
                .insert(3,"-");

        return numberLibrary.toString();
    }
}
