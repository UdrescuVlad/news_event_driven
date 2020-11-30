package com.event.driven.application;

import com.event.driven.actors.Reader;
import com.event.driven.events.Event;
import com.event.driven.filters.Filter;

public class Subscription {
    private Event event;
    public Filter filter;
    private Reader reader;

    public Subscription(Event event, Filter filter, Reader reader){
        this.event = event;
        this.filter = filter;
        this.reader = reader;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}
