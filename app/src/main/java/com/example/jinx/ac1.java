package com.example.jinx;

import android.widget.ImageView;

public class ac1 {
    //fields
    private String title;

    private String description;
    private String image;

    public ac1(String title,String image, String description) {
        this.title = title;
        this.image=image;
        this.description = description;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

