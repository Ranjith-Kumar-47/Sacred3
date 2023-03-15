package com.example.mahabandar;

public class UploadImageModel {
    private String imageName, imageShortDescription,imageLongDescription,ImageUrl,videoUrl;

    public UploadImageModel(String imageName, String imageShortDescription, String imageLongDescription, String imageUrl) {
        this.imageName = imageName;
        this.imageShortDescription = imageShortDescription;
        this.imageLongDescription = imageLongDescription;
        ImageUrl = imageUrl;
    }

    public UploadImageModel(String imageName, String imageShortDescription, String imageLongDescription, String imageUrl, String videoUrl) {
        this.imageName = imageName;
        this.imageShortDescription = imageShortDescription;
        this.imageLongDescription = imageLongDescription;
        ImageUrl = imageUrl;
        this.videoUrl = videoUrl;
    }

    public UploadImageModel() {
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageLongDescription() {
        return imageLongDescription;
    }

    public String getImageShortDescription() {
        return imageShortDescription;
    }

    public void setImageShortDescription(String imageShortDescription) {
        this.imageShortDescription = imageShortDescription;
    }

    public void setImageLongDescription(String imageLongDescription) {
        this.imageLongDescription = imageLongDescription;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
