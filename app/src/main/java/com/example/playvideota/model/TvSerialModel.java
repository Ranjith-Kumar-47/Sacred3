package com.example.playvideota.model;

public class TvSerialModel {
    String playlistId;
    String videoId;
    String title;
    String description;
    String channelId;
    String videoImage;
    String videoLiveBroadcastContent;

    public TvSerialModel(String playlistId, String videoId, String title, String description, String channelId, String videoImage) {
        this.playlistId = playlistId;
        this.videoId = videoId;
        this.title = title;
        this.description = description;
        this.channelId = channelId;
        this.videoImage = videoImage;

    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
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
}
