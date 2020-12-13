package com.event.driven.filters;

import com.event.driven.events.Event;

public class Domain extends Filter {

    private String domain;

    public Domain(String domain){
        this.domain = domain;
    }

    @Override
    public boolean apply(Event event) {
        return event.getNews().getNewsDomain().equals(domain);
    }
}
