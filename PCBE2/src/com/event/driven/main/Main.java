package com.event.driven.main;

import com.event.driven.application.Application;
import com.event.driven.actors.Editor;
import com.event.driven.actors.Reader;
import com.event.driven.exceptions.NewsAlreadyPublished;
import com.event.driven.exceptions.NonexistentNews;
import com.event.driven.filters.Author;
import com.event.driven.filters.Domain;
import com.event.driven.news.News;

public class Main {

    public static void main(String[] args) {
        try {
            Application app = Application.getInstance();

            Reader r1, r2, r3, r4;
            r1 = new Reader("Ion", app);
            r2 = new Reader("Anca", app);
            r3 = new Reader("Vlad", app);
            r4 = new Reader("Lorena", app);

            Editor e1, e2, e3;
            e1 = new Editor("Mircea", app);
            e2 = new Editor("Andrei", app);
            e3 = new Editor("Alex", app);

            app.addEditor(e1);
            app.addEditor(e2);

            app.subscribe(new Author(e1.getName()), r1);
            app.subscribe(new Author(e1.getName()), r2);
            app.subscribe(new Domain("Science"), r3);
            News newsPMD = new News("10.10.2010", "www.pmd.ro", e1.getName(), "Science", "Computer Science", "PMD Content ...");

            e1.publishNews(newsPMD);
//            e1.publishNews(newsPMD); -> throws NewsAlreadyPublished exception

            app.subscribe(null, r4);
            News newsPAD = new News("1.12.2020", "www.pad.oose.ro", e2.getName(), "Technology", "Software", "Content for PAD !!");

            e2.publishNews(newsPAD);

            News newsSport = new News("1.12.2020", "www.health.com", e3.getName(), "Health", "Sport", "Some sport news.");

            e2.modifyNews(newsPAD, "2.12.2020", "www.oose.pad.com");

            r1.readNews(newsPMD);
            r2.readNews(newsPMD);
            r3.readNews(newsPMD);

            e1.deleteNews(newsPMD);
            //e1.deleteNews(newsSport); -> throws NonExistentNews exception
            //e1.modifyNews(newsSport, "1.1.2001", "www.pad.oose.com");
        } catch (NonexistentNews | NewsAlreadyPublished newsException) {
            System.out.println("\n\n\n" + newsException.toString());
        }

    }
}
