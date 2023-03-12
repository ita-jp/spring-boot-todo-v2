package com.example.todo.controller;

public class TaskDTO {

    private long id;
    private String title;
    private boolean isCompleted;

    public TaskDTO(long id, String title, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.isCompleted = isCompleted;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}
