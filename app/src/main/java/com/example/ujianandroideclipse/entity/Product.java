package com.example.ujianandroideclipse.entity;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private int price;
    @SerializedName("description")
    private String description;
    @SerializedName("variant")
    private String variant;

    public Product(long id, String name, int price, String description, String variant) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.variant = variant;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
