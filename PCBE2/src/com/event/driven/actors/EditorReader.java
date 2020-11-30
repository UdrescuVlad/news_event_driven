package com.event.driven.actors;

import com.event.driven.events.Event;

public interface EditorReader {
    public void inform(Event event);
}
