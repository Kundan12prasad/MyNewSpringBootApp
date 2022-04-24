package com.practice.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Serializable> {
	
	

}
