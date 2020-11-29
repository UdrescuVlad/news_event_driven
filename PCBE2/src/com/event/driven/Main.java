package com.event.driven;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");

        List<Reader> readers = new ArrayList<>();

        readers.add(new Reader("Lore"));
        readers.add(new Reader("Alex"));
        readers.add(new Reader("Vlad"));

        Editor editor = new Editor("VLAD NEMES");

        for (Reader r : readers) {
            editor.addObserver(r);
        }

        System.out.println(editor.getName() + " publish some news.");
        editor.publishNews();

        System.out.println(editor.getName() + " modify some news.");
        editor.modifyNews();

        System.out.println(editor.getName() + " deleted some news.");
        editor.deleteNews();


    }
}
