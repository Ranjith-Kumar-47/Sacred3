package com.example.playvideota.model;

import android.net.Uri;

public class AdminLiveVideoModel {
    String videoId;
    String image;

    public AdminLiveVideoModel(String videoId, String image) {
        this.videoId = videoId;
        this.image = image;
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
