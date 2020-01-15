package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void welcomeSuccessTest() {

        assertEquals("Welcome to library !",
                BibliotecaApp.main(new String[100]));
    }
}
