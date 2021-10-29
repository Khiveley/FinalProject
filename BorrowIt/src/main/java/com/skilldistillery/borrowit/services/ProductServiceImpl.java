package com.skilldistillery.borrowit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.borrowit.entities.Product;
import com.skilldistillery.borrowit.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository prodRepo;
	
	@Override
	public List<Product> index() {
				return prodRepo.findAll();
	}

	@Override
	public Product show(int productId) {
		Optional<Product> productOpt =prodRepo.findById(productId);
		return productOpt.get();
	}

	@Override
	public Product create(Product product) {
		prodRepo.saveAndFlush(product);
		return product;
	}

	@Override
	public Product update(int id, Product product) {
		Product existingProduct = prodRepo(id);
		if(existingProduct != null) {
			existingProduct.setTitle(product.getTitle());
			existingProduct.setDescription(product.getDescription());
			existingProduct.setImageUrl(product.getImageUrl());
	}
		return null;
	}

	@Override
	public boolean destroy(int id) {
		// TODO Auto-generated method stub
		return false;
	}


}
