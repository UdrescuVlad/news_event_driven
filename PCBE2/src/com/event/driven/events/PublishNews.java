package com.event.driven.events;

import com.event.driven.news.News;

public class PublishNews extends Event {

    private News publishNews;

    public PublishNews(String first_publication,
                       String source, String author,String newsDomain, String newsSubdomain) {
        this.publishNews = new News(first_publication, source, author, newsDomain, newsSubdomain);
    }

    public PublishNews(){
        this.publishNews = new News();
    }

    @Override
    public void setNews(News news) {
        this.publishNews.setFirst_publication(news.getFirst_publication());
        this.publishNews.setLast_modified(news.getLast_modified());
        this.publishNews.setSource(news.getSource());
        this.publishNews.setAuthor(news.getAuthor());
        this.publishNews.setNewsDomain(news.getNewsDomain());
        this.publishNews.setNewsSubdomain(news.getNewsSubdomain());
    }

    @Override
    public String toString() {
        return "I've added this news: " + publishNews;
    }

    @Override
    public News getNews() {
        return publishNews;
    }
}
