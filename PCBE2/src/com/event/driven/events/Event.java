package com.event.driven.events;

import com.event.driven.News;

abstract class Event {
    abstract public String toString();
    abstract public News getNews();
}
