package com.event.driven.events;

import com.event.driven.news.News;

public abstract class Event {
    abstract public String toString();
    abstract public News getNews();
    abstract public void setNews(News news);
}
