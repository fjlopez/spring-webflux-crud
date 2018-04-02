package com.github.fjlopez.springwebfluxcrud.domain;

import java.util.Date;

public class ShowEvent {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private String id;
    private Date date;

    public ShowEvent(String id, Date date) {
        this.id = id;
        this.date = date;
    }
}
