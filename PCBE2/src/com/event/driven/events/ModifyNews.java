package com.event.driven.events;

import com.event.driven.news.News;

public class ModifyNews extends Event {

    private News modifyNews;

    public ModifyNews(News modifyNews, String modifing_date, String source) {
        this.modifyNews = modifyNews;
        this.modifyNews.setLast_modified(modifing_date);
        this.modifyNews.setSource(source);
    }

    @Override
    public void setNews(News news) {
        this.modifyNews.setFirst_publication(news.getFirst_publication());
        this.modifyNews.setLast_modified(news.getLast_modified());
        this.modifyNews.setSource(news.getSource());
        this.modifyNews.setAuthor(news.getAuthor());
    }

    @Override
    public String toString() {
        return "This news was modified: " + modifyNews.toString();
    }

    @Override
    public News getNews() {
        return modifyNews;
    }
}
