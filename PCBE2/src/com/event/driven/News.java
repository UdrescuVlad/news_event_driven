package com.event.driven;

public class News {

    private String first_publication;
    private String last_modified;
    private String source;
    private String author;

    public News(String first_publication, String last_modified, String source, String author) {
        this.first_publication = first_publication;
        this.last_modified = last_modified;
        this.source = source;
        this.author = author;
    }

    @Override
    public String toString() {
        return "News{" +
                "first_publication='" + first_publication + '\'' +
                ", last_modified='" + last_modified + '\'' +
                ", source='" + source + '\'' +
                ", author='" + author + '\'' +
                '}';
    }


    public String getFirst_publication() {
        return first_publication;
    }

    public void setFirst_publication(String first_publication) {
        this.first_publication = first_publication;
    }

    public String getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(String last_modified) {
        this.last_modified = last_modified;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
