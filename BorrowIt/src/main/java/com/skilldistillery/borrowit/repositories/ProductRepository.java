package com.skilldistillery.borrowit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.borrowit.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	public Product queryById(int productId);

}
