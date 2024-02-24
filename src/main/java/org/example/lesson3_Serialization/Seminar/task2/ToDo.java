package org.example.lesson3_Serialization.Seminar.task2;

import java.io.Serializable;

public class ToDo implements Serializable {

    private String title;
    private boolean isDone;

    public ToDo(String title) {
        this.title = title;
        this.isDone = false;
    }
    public ToDo() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }


}
