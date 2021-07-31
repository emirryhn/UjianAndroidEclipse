package com.example.ujianandroideclipse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ujianandroideclipse.entity.Product;
import com.example.ujianandroideclipse.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public List<Product> getAllProduct(){
	return productService.getAllProduct();	
	}
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.OK)
	public Product addNewProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
}
