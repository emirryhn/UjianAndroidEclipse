package com.example.ujianandroideclipse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ujianandroideclipse.adapter.ProductAdapter;
import com.example.ujianandroideclipse.entity.Product;
import com.example.ujianandroideclipse.service.ApiClient;
import com.example.ujianandroideclipse.service.ProductInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btnForm;

    RecyclerView rcvData;
    private ProductAdapter productAdapter;
    ArrayList<Product> prodData = new ArrayList<Product>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnForm = findViewById(R.id.btn_form);

        btnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(), addProductForm.class);
                startActivity(intent);
            }
        });

        ProductInterface productInterface = ApiClient.getRetrofit().create(ProductInterface.class);
        Call<ArrayList<Product>> call = productInterface.getAllProduct();

        call.enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
            try {
                //unknown purpose for developer, yet
                prodData.addAll(response.body());
                rcvData = findViewById(R.id.rcv_data);

                //prodData as ArrayList object required for adapter
                productAdapter = new ProductAdapter(prodData);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,  LinearLayoutManager.VERTICAL,  false);

                rcvData.setLayoutManager(layoutManager);
                rcvData.setAdapter(productAdapter);
            }catch(Exception e){
                e.printStackTrace();
            }
            }

            @Override
            //unknown purpose yet
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {

            }
        });

    }
}