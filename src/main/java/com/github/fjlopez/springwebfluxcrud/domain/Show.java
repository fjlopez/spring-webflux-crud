package com.github.fjlopez.springwebfluxcrud.domain;

public class Show {
    private String id;
    private String title;

    public Show(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
