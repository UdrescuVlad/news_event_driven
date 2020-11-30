package com.event.driven.application;

import com.event.driven.actors.Reader;
import com.event.driven.events.Event;
import com.event.driven.events.ModifyNews;
import com.event.driven.events.PublishNews;
import com.event.driven.filters.Filter;
import com.event.driven.news.News;

import java.util.ArrayList;

public class Application {
    private ArrayList<Subscription> subscriptions;
    private ArrayList<News> news;
    private static Application application = null;

    private Application() {
        this.subscriptions = new ArrayList<>();
        this.news = new ArrayList<>();
    }

    public static Application getInstance(){
        if(application == null)
            application = new Application();
        return application;
    }

    public void publish(Event event) {
        //TODO: Handling every event using a switch-case

        if(event instanceof PublishNews){

            System.out.println(event.getNews().getAuthor() + ": " + event);

            if(news.contains(event.getNews())) {
                this.publish(new ModifyNews(event.getNews(), event.getNews().getLast_modified(), event.getNews().getSource()));
            } else {
                news.add(event.getNews());
            }
        }

        for(Subscription sub : subscriptions) {
            if((sub.filter == null || sub.filter.apply(event)) && sub.getEvent().getClass().equals(event.getClass())) {
                sub.getReader().inform(event);
            }
        }
    }

    public void subscribe(Event event, Filter filter, Reader subscriber){
        Subscription subscription = new Subscription(event, filter, subscriber);

        if(!subscriptions.contains(subscription))
            subscriptions.add(subscription);
    }

    public void eventsHandling(){

    }
}
