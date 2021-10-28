package com.skilldistillery.borrowit.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.borrowit.entities.Product;

@Service
public interface ProductService {

	public List<Product> index();

	public Product show(int id);

	public Product create(Product product);

	public Product update(int id, Product product);

	public boolean destroy(int id);


}
