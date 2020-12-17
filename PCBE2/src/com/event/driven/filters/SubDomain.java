package com.event.driven.filters;

import com.event.driven.events.Event;

public class SubDomain extends Filter {

    private String subDomain;

    public SubDomain(String subDomain){
        this.subDomain = subDomain;
    }

    @Override
    public boolean apply(Event event) {
        return event.getNews().getNewsDomain().equals(subDomain);
    }
}
