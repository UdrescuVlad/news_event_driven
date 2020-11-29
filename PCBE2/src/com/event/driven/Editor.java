package com.event.driven;

import com.event.driven.events.DeleteNews;
import com.event.driven.events.ModifyNews;
import com.event.driven.events.PublishNews;

import java.util.Observable;

public class Editor extends Observable {

    public void publishNews() {

        PublishNews publishNews = new PublishNews("29.11.2020", "29.11.2020", "pcbe.ro", "vlad");
        setChanged();
        notifyObservers(publishNews.getNews());

    }

    public void deleteNews() {

        DeleteNews deleteNews = new DeleteNews("28.11.2020", "28.11.2020", "Google.ro", "nemes");
        setChanged();
        notifyObservers(deleteNews.getNews());

    }

    public void modifyNews() {

        ModifyNews modifyNews = new ModifyNews("27.11.2020", "27.11.2020", "DAN_COSMA.ro", "vlad nemes");
        setChanged();
        notifyObservers(modifyNews.getNews());

    }

    public Editor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String name;

}
