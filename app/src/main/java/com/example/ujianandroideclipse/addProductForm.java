package com.example.ujianandroideclipse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ujianandroideclipse.adapter.ProductAdapter;
import com.example.ujianandroideclipse.entity.Product;
import com.example.ujianandroideclipse.service.ApiClient;
import com.example.ujianandroideclipse.service.ProductInterface;

import java.util.ArrayList;
import java.util.Collection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class addProductForm extends AppCompatActivity {

    EditText editName, editPrice, editDesc, editVariant;
    Button btnSubmit;
    ProductInterface productInterface;
    RecyclerView rcvData;
    ProductAdapter productAdapter;

    ArrayList<Product> prodData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_form);

        editName = findViewById(R.id.edit_name);
        editPrice = findViewById(R.id.edit_price);
        editDesc = findViewById(R.id.edit_description);
        editVariant = findViewById(R.id.edit_variant);
        btnSubmit = findViewById(R.id.btn_submit);

        productInterface = ApiClient.getRetrofit().create(ProductInterface.class);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveProd(createRequest());

            }
        });
    }

    public Product createRequest(){
        Product product = new Product();
        product.setName(editName.getText().toString());
        product.setPrice(Integer.parseInt(editPrice.getText().toString()));
        product.setDescription(editDesc.getText().toString());
        product.setVariant(editVariant.getText().toString());

        return product;
    }

    public void saveProd(Product product){
        Call<Product> call = ApiClient.getProdInterface().addProduct(product);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if(response.isSuccessful()){
                    Toast.makeText(addProductForm.this, "Saved success", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(addProductForm.this, "failed request", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast.makeText(addProductForm.this, "failed request", Toast.LENGTH_SHORT).show();
            }
        });
    }

}