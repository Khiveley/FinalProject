package com.skilldistillery.borrowit.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.borrowit.entities.Product;


public interface ProductService {

	List<Product> index();
	
	public Product show(int id);

	Product create(Product product);

	Product update(Integer id, Product product);


}
