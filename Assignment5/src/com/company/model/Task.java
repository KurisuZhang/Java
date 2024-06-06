package com.company.model;

public class Task {
    private static int nextId = 1; // Static variable to keep track of the next ID

    private int id;
    private String title;
    private String text;
    private String assignedTo;
    private boolean completed;

    // Constructor
    public Task(String title, String text, String assignedTo) {
        this.id = nextId++;
        this.title = title;
        this.text = text;
        this.assignedTo = assignedTo;
        this.completed = false;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", assignedTo='" + assignedTo + '\'' +
                ", completed=" + completed +
                '}';
    }
}
