package com.example.demo.model;

import java.util.Date;

public class Task {

    private int id;
    private String name;
    private Date date;

    public Task() {}

    public Task(int id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate() {

        date = new Date();
    }



}

