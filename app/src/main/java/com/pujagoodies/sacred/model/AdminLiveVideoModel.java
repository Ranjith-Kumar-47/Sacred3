package com.pujagoodies.sacred.model;

import android.net.Uri;

public class AdminLiveVideoModel {
    String videoId;
    String image;
    String title;
    String description;

    public AdminLiveVideoModel(String videoId, String image, String title, String description) {
        this.videoId = videoId;
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public AdminLiveVideoModel(String videoId, String image) {
        this.videoId = videoId;
        this.image = image;
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

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public Uri getImage() {
        return Uri.parse(image);
    }

    public void setImage(String image) {
        this.image = image;
    }
}
