package model;

import java.util.ArrayList;

public class MainGods {

    public String getGodName() {
        return godName;
    }

    public void setGodName(String godName) {
        this.godName = godName;
    }

    public ArrayList<GodImages> getGodImages() {
        return godImages;
    }

    public void setGodImages(ArrayList<GodImages> godImages) {
        this.godImages = godImages;
    }

    public MainGods(String godName, String image) {
        this.godName = godName;
        this.image = image;
    }

    public MainGods(String godName, ArrayList<GodImages> godImages) {
        this.godName = godName;
        this.godImages = godImages;
    }

    public MainGods(String godName, ArrayList<GodImages> godImages, String godMainName) {
        this.godName = godName;
        this.godImages = godImages;
        this.godMainName = godMainName;
    }

    public MainGods() {
    }

    private String godName;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private ArrayList<GodImages> godImages;

    public String getGodMainName() {
        return godMainName;
    }

    public void setGodMainName(String godMainName) {
        this.godMainName = godMainName;
    }

    private String godMainName;
}
