package com.example.myapplication.Model;

public class Shoe {
    private String name;
    private String description;
    private int qty;
    private String image;

    public Shoe(String name, String description, int qty, String image) {
        this.name = name;
        this.description = description;
        this.qty = qty;
        this.image = image;
    }

    public Shoe(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
