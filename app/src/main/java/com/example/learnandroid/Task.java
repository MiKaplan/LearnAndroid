package com.example.learnandroid;


import java.io.Serializable;

public class Task implements Serializable {

    private static final long serialVersionUID = -3162801157068054221L;
    private final String name;
    private final int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }
}
