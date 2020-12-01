package com.event.driven.application;

import com.event.driven.actors.Reader;
import com.event.driven.filters.Filter;

public class Subscription {
    public Filter filter;
    private Reader reader;

    public Subscription( Filter filter, Reader reader){
        this.filter = filter;
        this.reader = reader;
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
