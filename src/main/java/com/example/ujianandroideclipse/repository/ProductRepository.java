package com.example.ujianandroideclipse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ujianandroideclipse.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
