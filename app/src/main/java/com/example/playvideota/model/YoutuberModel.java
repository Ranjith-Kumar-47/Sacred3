package com.example.playvideota.model;

public class YoutuberModel {
    int youtuberImage;
    String youtuberName;

    public YoutuberModel(int youtuberImage, String youtuberName) {
        this.youtuberImage = youtuberImage;
        this.youtuberName = youtuberName;
    }

    public int getYoutuberImage() {
        return youtuberImage;
    }

    public void setYoutuberImage(int youtuberImage) {
        this.youtuberImage = youtuberImage;
    }

    public String getYoutuberName() {
        return youtuberName;
    }

    public void setYoutuberName(String youtuberName) {
        this.youtuberName = youtuberName;
    }
}
