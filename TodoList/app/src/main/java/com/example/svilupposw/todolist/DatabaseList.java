package com.example.svilupposw.todolist;

import android.provider.ContactsContract;

/**
 * Created by svilupposw on 22/03/16.
 */
public class DatabaseList {
    private boolean done;
    private String title;
    private String description;
    private String uuid;

    public DatabaseList(){}

    public DatabaseList(boolean done,String title,String description){
        this.done = done;
        this.title = title;
        this.description = description;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
