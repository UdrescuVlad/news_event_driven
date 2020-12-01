package com.event.driven.filters;

import com.event.driven.events.Event;

public class Author extends Filter {

    private String author;

    public Author(String author) {
        this.author = author;
    }

//    public void setAuthor(String author) {
//        this.author = author;
//    }

    @Override
    public boolean apply(Event event) {
        if(event.getNews().getAuthor().equals(author)) {
            return true;
        } else {
            return false;
        }
    }
}
