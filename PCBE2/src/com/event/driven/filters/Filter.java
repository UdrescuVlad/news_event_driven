package com.event.driven.filters;

import com.event.driven.events.Event;

public abstract class Filter {
    abstract public boolean apply(Event event);
}
