package com.example.ujianandroideclipse.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ujianandroideclipse.R;
import com.example.ujianandroideclipse.entity.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private ArrayList<Product> productList;
    ImageView imageView;

    public ProductAdapter(ArrayList<Product> productList){
        this.productList = productList;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        private TextView textName, textPrice, textDescription, textVariant;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.text_name);
            textPrice = itemView.findViewById(R.id.text_price);
            textDescription = itemView.findViewById(R.id.text_description);
            textVariant = itemView.findViewById(R.id.text_variant);
//            imageView = itemView.findViewById(R.id.image_view);
        }
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //unknown purpose yet(fully)
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {

        //set value from database
        holder.textName.setText("Product Name : " + productList.get(position).getName());
        holder.textPrice.setText("Price : " + String.valueOf(productList.get(position).getPrice()));
        holder.textDescription.setText("Description : " + productList.get(position).getDescription());
        holder.textVariant.setText("Variant : " + productList.get(position).getVariant());
    }


    @Override
    public int getItemCount() {
        return (productList != null) ? productList.size() : 0;
    }
}
