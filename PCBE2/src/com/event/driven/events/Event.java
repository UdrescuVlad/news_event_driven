package com.event.driven.events;

import com.event.driven.news.News;

abstract class Event {
    abstract public String toString();
    abstract public News getNews();
}
