package com.example.vaishakhgd.seproject;

/**
 * Created by vaishakh g d on 04-10-2017.
 */
public class Hero {
    String name, imageUrl;

    public Hero(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
