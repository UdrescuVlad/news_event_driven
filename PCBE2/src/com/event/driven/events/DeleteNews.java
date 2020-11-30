package com.event.driven.events;

import com.event.driven.news.News;

public class DeleteNews extends Event {

    private News deletedNews;

    public DeleteNews(News news) {
        this.deletedNews = news;
    }

    @Override
    public void setNews(News news) {
        this.deletedNews.setFirst_publication(news.getFirst_publication());
        this.deletedNews.setLast_modified(news.getLast_modified());
        this.deletedNews.setSource(news.getSource());
        this.deletedNews.setAuthor(news.getAuthor());
    }

    @Override
    public String toString() {
        return "This news was deleted: " + deletedNews.toString();
    }

    @Override
    public News getNews() {
        return deletedNews;
    }
}
