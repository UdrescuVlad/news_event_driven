package com.event.driven.events;

import com.event.driven.News;

public class PublishNews extends Event {

    private News publish_news;

    public PublishNews(String first_publication, String last_modified,
                       String source, String author) {
        this.publish_news = new News(first_publication, last_modified, source, author);
    }

    @Override
    public String toString() {
        return "I've added this news: " + publish_news.toString();
    }

    @Override
    public News getNews() {
        return publish_news;
    }
}
