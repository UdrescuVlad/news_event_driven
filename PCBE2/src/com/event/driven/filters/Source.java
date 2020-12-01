package com.event.driven.filters;

import com.event.driven.events.Event;

public class Source extends Filter {

    private String  source;

    public Source(String source) {
        this.source = source;
    }

//    public void setSource(String source) {
//        this.source = source;
//    }

    @Override
    public boolean apply(Event event) {
        if(event.getNews().getSource().equals(source)) {
            return true;
        } else {
            return false;
        }
    }
}
