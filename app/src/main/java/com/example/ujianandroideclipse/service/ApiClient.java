package com.example.ujianandroideclipse.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

        public static Retrofit retrofit;
        public static final String URL = "http://192.168.0.14:8080/product/";

        public static Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
        }

        public static ProductInterface getProdInterface(){
                ProductInterface productInterface = getRetrofit().create(ProductInterface.class);
                return productInterface;
        }
}
