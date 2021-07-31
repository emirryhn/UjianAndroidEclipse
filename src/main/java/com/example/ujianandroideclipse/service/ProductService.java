package com.example.ujianandroideclipse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ujianandroideclipse.entity.Product;
import com.example.ujianandroideclipse.repository.ProductRepository;

@Service
public class ProductService implements ProductInterface {

	@Autowired
	ProductRepository productRepo;
	
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return this.productRepo.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}
	

}
