package com.event.driven.events;

import com.event.driven.news.News;

public class ModifyNews extends Event {

    private News modify_news;

    public ModifyNews(String first_publication, String last_modified,
                      String source, String author) {
        this.modify_news = new News(first_publication, last_modified, source, author);
    }

    @Override
    public String toString() {
        return "This news was modified: " + modify_news.toString();
    }

    @Override
    public News getNews() {
        return modify_news;
    }
}
