package com.skilldistillery.borrowit.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.borrowit.entities.Product;


public interface ProductService {

	public Product show(int id);

	Product create(String username, Product product);

	Product update(String username, int id, Product product);

	boolean destroy(String username, int id);

	List<Product> index();


}
