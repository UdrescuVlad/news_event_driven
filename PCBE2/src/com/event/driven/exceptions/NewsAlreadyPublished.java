package com.event.driven.exceptions;

public class NewsAlreadyPublished extends Exception {

    public NewsAlreadyPublished(String s) {
        super("This " + s + " was already published.\n");
    }
}
