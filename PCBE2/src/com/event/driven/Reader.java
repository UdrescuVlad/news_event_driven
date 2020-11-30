package com.event.driven;

import com.event.driven.news.News;

import java.util.Observable;
import java.util.Observer;

public class Reader implements Observer {

    @Override
    public void update(Observable observable, Object o) {
        if (!(o.equals(null)) && (o instanceof News)) {
            System.out.printf("\n %s just readed! \n" + o.toString(), getName());
        }
    }

    public Reader(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String name;


}
