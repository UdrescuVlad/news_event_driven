package com.event.driven.application;

import com.event.driven.actors.Editor;
import com.event.driven.actors.Reader;
import com.event.driven.events.*;
import com.event.driven.exceptions.NewsAlreadyPublished;
import com.event.driven.exceptions.NonexistentNews;
import com.event.driven.filters.Filter;
import com.event.driven.news.News;

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;

public class Application {
    private ArrayList<Subscription> subscriptions;
    private ArrayList<News> news;
    private ArrayList<Editor> editors;
    private static Application application = null;

    private Application() {
        this.subscriptions = new ArrayList<>();
        this.news = new ArrayList<>();
        this.editors = new ArrayList<>();
    }

    public static Application getInstance() {
        if (application == null)
            application = new Application();
        return application;
    }

    public void publish(Event event) throws NonexistentNews, NewsAlreadyPublished {

        //Publish news
        if (event instanceof PublishNews) {
            if (news.size() == 0)
                news.add(event.getNews());
            else {
                //TODO: make some new contains method
                if (!(news.contains(event.getNews())))
                    news.add(event.getNews());
                else throw new NewsAlreadyPublished(event.getNews().toString());
                System.out.println("\n\n\n" + event.getNews().getAuthor() + ": " + event);
            }
            for (Subscription sub : subscriptions) {
                if ((sub.filter == null || sub.filter.apply(event))/* && sub.getEvent().getClass().equals(event.getClass())*/) {
                    sub.getReader().inform(event);
                }
            }

            //Modify news
        } else if (event instanceof ModifyNews) {

            //if(news.contains(event.getNews())) {

            for (News n : news) {
                if (event.getNews().equals(n)) {
                    n.setLast_modified(event.getNews().getLast_modified());
                    n.setSource(event.getNews().getSource());
                    break;
                }
            }

            System.out.println("\n\n\n" + event.getNews().getAuthor() + ": " + event);

            for (Subscription sub : subscriptions) {
                if ((sub.filter == null || sub.filter.apply(event))/* && sub.getEvent().getClass().equals(event.getClass())*/) {
                    sub.getReader().inform(event);
                }
            }
            //} else {
            //System.out.println("\n\n\n" + "!!Nonexistent news!!");
            //}

            //Delete news
        } else if (event instanceof DeleteNews) {
            for (News n : news) {
                if (event.getNews().equals(n)) {
                    news.remove(event.getNews());
                    break;
                } else throw new NonexistentNews(event.getNews().toString());
            }
            System.out.println("\n\n\n" + event.getNews().getAuthor() + ": " + event);

            for (Subscription sub : subscriptions) {
                if ((sub.filter == null || sub.filter.apply(event))/* && sub.getEvent().getClass().equals(event.getClass())*/) {
                    sub.getReader().inform(event);
                }
            }

            //Read news
        } else if (event instanceof ReadNews) {
            for (Editor e : editors) {
                if (event.getNews().getAuthor().equals(e.getName())) {
                    event.getNews().increaseReadersCount();
                    e.inform(event);
                    break;
                }
            }
        }
    }

    public void subscribe(Filter filter, Reader subscriber) {
        Subscription subscription = new Subscription(filter, subscriber);

        if (!subscriptions.contains(subscription)) {
            subscriptions.add(subscription);
        }
    }

    public void addEditor(Editor editor) {
        if (!editors.contains(editor)) {
            editors.add(editor);
        }
    }
}
