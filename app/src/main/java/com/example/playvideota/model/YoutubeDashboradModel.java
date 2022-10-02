package com.example.playvideota.model;

public class YoutubeDashboradModel {
    String videoImage;
    String videoDescription;
    String videoTitle;
    String videoId;
    String videoLiveBroadcastContent;
    String channelId;
    String channelIcon;
    String channelName;



    public YoutubeDashboradModel(String videoImage, String videoDescription, String videoTitle, String videoId, String videoLiveBroadcastContent, String channelId, String channelIcon, String channelName) {
        this.videoImage = videoImage;
        this.videoDescription = videoDescription;
        this.videoTitle = videoTitle;
        this.videoId = videoId;
        this.videoLiveBroadcastContent = videoLiveBroadcastContent;
        this.channelId = channelId;
        this.channelIcon = channelIcon;
        this.channelName = channelName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelIcon() {
        return channelIcon;
    }

    public void setChannelIcon(String channelIcon) {
        this.channelIcon = channelIcon;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(String videoImage) {
        this.videoImage = videoImage;
    }

    public String getVideoLiveBroadcastContent() {
        return videoLiveBroadcastContent;
    }

    public void setVideoLiveBroadcastContent(String videoLiveBroadcastContent) {
        this.videoLiveBroadcastContent = videoLiveBroadcastContent;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }


    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }
}
