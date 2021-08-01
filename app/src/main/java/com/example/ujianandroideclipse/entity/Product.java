package com.example.ujianandroideclipse.entity;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private int price;
    @SerializedName("description")
    private String description;
    @SerializedName("variant")
    private String variant;

    public Product(String name, int price, String description, String variant) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.variant = variant;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }


}
