package com.pujagoodies.sacred.model;

public class UsersModel {
    String image,email,name;
    private String  password;

    public UsersModel(String image, String email, String name) {
        this.image = image;
        this.email = email;
        this.name = name;
    }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
