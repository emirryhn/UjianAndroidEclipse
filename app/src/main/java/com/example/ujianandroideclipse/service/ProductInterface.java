package com.example.ujianandroideclipse.service;

import com.example.ujianandroideclipse.entity.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ProductInterface {

    @GET("/product/")
    Call<ArrayList<Product>> getAllProduct();

//    @POST("/product/add")
//    @FormUrlEncoded
//    Call<Product> addProduct(@Field("name") String name,
//                             @Field("price") int price,
//                             @Field("description") String description,
//                             @Field("variant") String variant);

    @POST("/product/add")
    Call<Product> addProduct(@Body Product product);
}
