package com.pujagoodies.sacred.model;

public class PdfModel {
    private String title, shortDescription, pdfUrl, imageUrl;

    public PdfModel(String title, String shortDescription, String pdfUrl, String imageUrl) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.pdfUrl = pdfUrl;
        this.imageUrl = imageUrl;
    }

    public PdfModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
