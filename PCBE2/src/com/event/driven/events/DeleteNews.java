package com.event.driven.events;

import com.event.driven.news.News;

public class DeleteNews extends Event {

    private News deleted_news;

    public DeleteNews(String first_publication, String last_modified,
                      String source, String author) {
        this.deleted_news = new News(first_publication, last_modified, source, author);
    }

    @Override
    public String toString() {
        return "This news was deleted: " + deleted_news.toString();
    }

    @Override
    public News getNews() {
        return deleted_news;
    }
}
