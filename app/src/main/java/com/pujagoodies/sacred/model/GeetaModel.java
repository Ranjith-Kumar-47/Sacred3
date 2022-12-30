package com.pujagoodies.sacred.model;

public class GeetaModel {
    String adhya;
    String slok;
    String slokSanskrit;
    String slokSar;

    public GeetaModel(String adhya, String slok, String slokSanskrit, String slokSar) {
        this.adhya = adhya;
        this.slok = slok;
        this.slokSanskrit = slokSanskrit;
        this.slokSar = slokSar;
    }

    public String getAdhya() {
        return adhya;
    }

    public void setAdhya(String adhya) {
        this.adhya = adhya;
    }

    public String getSlok() {
        return slok;
    }

    public void setSlok(String slok) {
        this.slok = slok;
    }

    public String getSlokSanskrit() {
        return slokSanskrit;
    }

    public void setSlokSanskrit(String slokSanskrit) {
        this.slokSanskrit = slokSanskrit;
    }

    public String getSlokSar() {
        return slokSar;
    }

    public void setSlokSar(String slokSar) {
        this.slokSar = slokSar;
    }
}
