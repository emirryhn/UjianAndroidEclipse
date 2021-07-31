package com.example.ujianandroideclipse.service;

import java.util.List;

import com.example.ujianandroideclipse.entity.Product;

public interface ProductInterface {
	
	public List<Product> getAllProduct();
	public Product addProduct(Product product);

}
