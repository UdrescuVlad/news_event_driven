package com.event.driven.actors;

import com.event.driven.application.Application;
import com.event.driven.events.*;
import com.event.driven.news.News;

public class Reader implements EditorReader {

    private String name;
    private Application app;

    public Reader(String name, Application app) {
        this.name = name;
        this.app = app;
    }

    public void readNews(News news){
        ReadNews readNews = new ReadNews(news);
        app.publish(readNews);
    }

    public String getName() { return name; }

    @Override
    public void inform(Event event) {
        if(event instanceof PublishNews) {
            System.out.println("\n" + this.getName() + ", you've got some news!" + "\n\t" + event.getNews());
        } else if(event instanceof ModifyNews) {
            System.out.println("\n" + this.getName() + ", this news has modified!" + "\n\t" + event.getNews());
        } else if(event instanceof DeleteNews) {
            System.out.println("\n" + this.getName() + ", this news has been deleted!" + "\n\t" + event.getNews());
        }
    }
}
