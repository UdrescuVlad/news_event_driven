package com.event.driven.exceptions;

public class NonexistentNews extends Exception {
    public NonexistentNews(String s) {
        super("This " + s + " doesn't exist.\n");
    }
}
