package com.event.driven.actors;

import com.event.driven.application.Application;
import com.event.driven.exceptions.NewsAlreadyPublished;
import com.event.driven.exceptions.NonexistentNews;
import com.event.driven.news.News;
import com.event.driven.events.DeleteNews;
import com.event.driven.events.Event;
import com.event.driven.events.ModifyNews;
import com.event.driven.events.PublishNews;

public class Editor implements EditorReader {

    private String name;
    private Application app;

    public Editor(String name, Application app) {
        this.name = name;
        this.app = app;
    }

    public void publishNews(News news) throws NonexistentNews, NewsAlreadyPublished {
        PublishNews publishNews = new PublishNews(news.getFirst_publication(), news.getSource(), news.getAuthor(), news.getNewsDomain(), news.getNewsSubdomain());
        app.publish(publishNews);
    }

    public void deleteNews(News news) throws NonexistentNews, NewsAlreadyPublished {
        DeleteNews deleteNews = new DeleteNews(news);
        app.publish(deleteNews);
    }

    public void modifyNews(News news, String modifyingDate, String newSource) throws NonexistentNews, NewsAlreadyPublished {
        ModifyNews modifyNews = new ModifyNews(news, modifyingDate, newSource);
        app.publish(modifyNews);
    }

    public String getName() {
        return name;
    }

    @Override
    public void inform(Event event) {
        System.out.println("\n*" + getName() + ", this news: " + event.getNews() + " have been read by " + event.getNews().getReadersCount() + " readers.");
    }
}
