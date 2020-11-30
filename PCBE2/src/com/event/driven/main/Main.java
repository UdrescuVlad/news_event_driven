package com.event.driven.main;

import com.event.driven.application.Application;
import com.event.driven.actors.Editor;
import com.event.driven.actors.Reader;
import com.event.driven.events.Event;
import com.event.driven.events.PublishNews;
import com.event.driven.news.News;

public class Main {

    public static void main(String[] args) {

        Application app = Application.getInstance();

        Reader r1, r2, r3, r4;
        r1 = new Reader("Ionel", app);
        r2 = new Reader("Bonel", app);
        r3 = new Reader("Vladut", app);
        r4 = new Reader("Gica", app);

        Editor e1, e2;
        e1 = new Editor("Bogdan", app);
        e2 = new Editor("Andrei", app);

        Event publishNews = new PublishNews();

        app.subscribe(publishNews, null, r1);
        app.subscribe(publishNews, null, r2);
        app.subscribe(publishNews, null, r3);
        News newsPMD = new News("10.10.2010", "www.pmd.ro", e1.getName());
        publishNews.setNews(newsPMD);

        e1.publishNews(publishNews.getNews());


        Event publishNews1 = new PublishNews();

        app.subscribe(publishNews1, null, r4);
        News newsPAD = new News("1.12.2020", "www.pad.oose.ro", e2.getName());
        publishNews1.setNews(newsPAD);
        e2.publishNews(publishNews1.getNews());


    }
}
