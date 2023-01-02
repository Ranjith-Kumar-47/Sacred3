package com.pujagoodies.sacred.model;

import android.widget.ImageView;

public class SahityaImageModel {
    String sahityaImage;
    String sahityaImageAboutTv,sahityaTitle,sahityaTitleCategories;

    public SahityaImageModel(String sahityaImage, String sahityaImageAboutTv, String sahityaTitle, String sahityaTitleCategories) {
        this.sahityaImage = sahityaImage;
        this.sahityaImageAboutTv = sahityaImageAboutTv;
        this.sahityaTitle = sahityaTitle;
        this.sahityaTitleCategories = sahityaTitleCategories;
    }

    public String getSahityaImage() {
        return sahityaImage;
    }

    public void setSahityaImage(String sahityaImage) {
        this.sahityaImage = sahityaImage;
    }

    public String getSahityaImageAboutTv() {
        return sahityaImageAboutTv;
    }

    public void setSahityaImageAboutTv(String sahityaImageAboutTv) {
        this.sahityaImageAboutTv = sahityaImageAboutTv;
    }

    public String getSahityaTitle() {
        return sahityaTitle;
    }

    public void setSahityaTitle(String sahityaTitle) {
        this.sahityaTitle = sahityaTitle;
    }

    public String getSahityaTitleCategories() {
        return sahityaTitleCategories;
    }

    public void setSahityaTitleCategories(String sahityaTitleCategories) {
        this.sahityaTitleCategories = sahityaTitleCategories;
    }
}
