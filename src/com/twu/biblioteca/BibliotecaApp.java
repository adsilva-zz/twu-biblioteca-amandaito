package com.twu.biblioteca;

import com.twu.biblioteca.service.MainService;

public class BibliotecaApp {

    public static void main(String[] args) {
        MainService mainService = new MainService();

        System.out.println(mainService.callWelcomeMessage());
    }
}
