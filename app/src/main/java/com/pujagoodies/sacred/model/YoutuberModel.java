package com.pujagoodies.sacred.model;

public class YoutuberModel {
    String youtuberImage;
    String youtuberName;
    String youtuberId;
    String youtuberBannerImage;
    String liveStatus;

    public YoutuberModel(String youtuberImage, String youtuberName, String youtuberId, String youtuberBannerImage) {
        this.youtuberImage = youtuberImage;
        this.youtuberName = youtuberName;
        this.youtuberId = youtuberId;
        this.youtuberBannerImage = youtuberBannerImage;
    }

    public YoutuberModel(String youtuberImage, String youtuberName, String youtuberId, String youtuberBannerImage, String liveStatus) {
        this.youtuberImage = youtuberImage;
        this.youtuberName = youtuberName;
        this.youtuberId = youtuberId;
        this.youtuberBannerImage = youtuberBannerImage;
        this.liveStatus = liveStatus;
    }

    public String getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(String liveStatus) {
        this.liveStatus = liveStatus;
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
