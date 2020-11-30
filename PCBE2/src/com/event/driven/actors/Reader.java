package com.event.driven.actors;

import com.event.driven.application.Application;
import com.event.driven.news.News;
import com.event.driven.events.Event;
import com.event.driven.events.ReadNews;

public class Reader implements EditorReader {

    private String name;
    private Application app;

    public Reader(String name, Application app) {
        this.name = name;
        this.app = app;
    }

    public ReadNews readNews(News news){
        ReadNews readNews = new ReadNews(news);
        //System.out.println(readNews);
        app.publish(readNews);

        return readNews;
    }

    public String getName() { return name; }

    @Override
    public void inform(Event event) {
        System.out.println(this.getName() + ", you've got some news!" + "\n\t" + event.getNews());
    }
}
