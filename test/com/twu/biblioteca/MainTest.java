package com.twu.biblioteca;

import com.twu.biblioteca.service.MainService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    private MainService mainService = new MainService();

    @Test
    public void welcomeSuccessTest() {
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore", mainService.callWelcomeMessage());
    }
}
