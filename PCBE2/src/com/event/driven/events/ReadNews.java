package com.event.driven.events;

import com.event.driven.news.News;

public class ReadNews extends Event {

    private News readNews;

    public ReadNews(News readNews){
        this.readNews = readNews;
    }

    @Override
    public void setNews(News news) {
        this.readNews.setFirst_publication(news.getFirst_publication());
        this.readNews.setLast_modified(news.getLast_modified());
        this.readNews.setSource(news.getSource());
        this.readNews.setAuthor(news.getAuthor());
    }

    @Override
    public String toString() {
        return "I've read this news: " + readNews;
    }

    @Override
    public News getNews() {
        return readNews;
    }
}
