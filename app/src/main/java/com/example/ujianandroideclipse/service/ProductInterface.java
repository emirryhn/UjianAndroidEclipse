package com.example.ujianandroideclipse.service;

import com.example.ujianandroideclipse.entity.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductInterface {

    @GET("/product/")
    Call<ArrayList<Product>> getAllProduct();
}
