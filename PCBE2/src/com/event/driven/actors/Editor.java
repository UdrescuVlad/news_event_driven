package com.event.driven.actors;

import com.event.driven.application.Application;
import com.event.driven.news.News;
import com.event.driven.events.DeleteNews;
import com.event.driven.events.Event;
import com.event.driven.events.ModifyNews;
import com.event.driven.events.PublishNews;

public class Editor implements EditorReader {

    private String name;
    private Application app;

    public PublishNews publishNews(News news) {
        PublishNews publishNews = new PublishNews(news.getFirst_publication(), news.getSource(), news.getAuthor());
        app.publish(publishNews);

        return publishNews;
    }

    public void deleteNews(News news) {
        DeleteNews deleteNews = new DeleteNews(news);
    }

    public void modifyNews(News news) {
        ModifyNews modifyNews = new ModifyNews(news, "27.11.2020", "DAN_COSMA.ro");
    }

    public Editor(String name, Application app) {
        this.name = name;
        this.app = app;
    }

    public String getName() {
        return name;
    }

    //TODO: Handle receiving of a ReadNews event
    @Override
    public void inform(Event event) {

    }
}
