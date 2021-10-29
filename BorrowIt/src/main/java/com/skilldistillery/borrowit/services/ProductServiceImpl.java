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
		product.setEnabled(true);
		prodRepo.saveAndFlush(product);
		return product;
	}

	@Override
	public Product update(Integer id, Product product) {
		Optional<Product> productOpt= prodRepo.findById(id);
		
		if(productOpt.isPresent()) {
			Product managedProduct = productOpt.get();
			managedProduct.setTitle(product.getTitle());
			managedProduct.setDescription(product.getDescription());
			managedProduct.setImageUrl(product.getImageUrl());
			prodRepo.saveAndFlush(managedProduct);
			return managedProduct;
	}
		return null;
	}
	
	@Override
	public boolean destroy(Integer id) {
		Optional<Product> productOpt= prodRepo.findById(id);
		
		if(productOpt.isPresent()) {
			Product managedProduct = productOpt.get();
			managedProduct.setEnabled(false);
			prodRepo.saveAndFlush(managedProduct);
			return true;
	}
		return false;
	}


}
