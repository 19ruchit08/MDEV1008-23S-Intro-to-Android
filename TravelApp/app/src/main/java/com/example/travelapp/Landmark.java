package com.example.travelapp;

import java.io.Serializable;

public class Landmark implements Serializable {
    private String title;
    private int imageResourceId;
    private String description;

    public Landmark(String title, int imageResourceId, String description) {
        this.title = title;
        this.imageResourceId = imageResourceId;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getDescription() {
        return description;
    }
}
