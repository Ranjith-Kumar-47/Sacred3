package com.example.playvideota.model;

public class YoutuberModel {
    String youtuberImage;
    String youtuberName;
    String youtuberId;
    String youtuberBannerImage;

    public YoutuberModel(String youtuberImage, String youtuberName, String youtuberId, String youtuberBannerImage) {
        this.youtuberImage = youtuberImage;
        this.youtuberName = youtuberName;
        this.youtuberId = youtuberId;
        this.youtuberBannerImage = youtuberBannerImage;
    }

    public String getYoutuberId() {
        return youtuberId;
    }

    public String getYoutuberBannerImage() {
        return youtuberBannerImage;
    }

    public void setYoutuberBannerImage(String youtuberBannerImage) {
        this.youtuberBannerImage = youtuberBannerImage;
    }

    public void setYoutuberId(String youtuberId) {
        this.youtuberId = youtuberId;
    }

    public String getYoutuberImage() {
        return youtuberImage;
    }

    public void setYoutuberImage(String youtuberImage) {
        this.youtuberImage = youtuberImage;
    }

    public String getYoutuberName() {
        return youtuberName;
    }

    public void setYoutuberName(String youtuberName) {
        this.youtuberName = youtuberName;
    }
}
