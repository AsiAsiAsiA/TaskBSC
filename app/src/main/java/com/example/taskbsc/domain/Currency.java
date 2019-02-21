package com.example.taskbsc.domain;

public enum Currency {
    RUR("RUR"), USD("USD"), EUR("EUR");

    private String image;

    Currency(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
}
