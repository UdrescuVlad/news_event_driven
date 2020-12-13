package com.event.driven.filters;

import com.event.driven.events.Event;

public class Author extends Filter {

    private String author;

    public Author(String author) {
        this.author = author;
    }

    @Override
    public boolean apply(Event event) {
        return event.getNews().getAuthor().equals(author);
    }
}
