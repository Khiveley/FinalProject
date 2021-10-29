package com.skilldistillery.borrowit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.borrowit.entities.ProductItem;
import com.skilldistillery.borrowit.repositories.ProductItemRepository;

@Service
public class ProductItemServiceImpl implements ProductItemService{
	
	@Autowired
	private ProductItemRepository repo;

	@Override
	public ProductItem getProductItemById(Integer id) {
		Optional<ProductItem> prodOpt = repo.findById(id);
		if (prodOpt.isPresent()) {
			return prodOpt.get();
		}
		return null;
	}

	@Override
	public List<ProductItem> getAll() {
		return repo.findAll();
	}

	@Override
	public List<ProductItem> getAllAvailableProductItems() {
		return repo.findByAvailable(true);
	}

	@Override
	public ProductItem createProductItem(ProductItem productItem) {
		repo.save(productItem);
		return productItem;
	}

	@Override
	public ProductItem updateProductItem(int id, ProductItem productItem) {
		Optional<ProductItem> prodOpt = repo.findById(id);
		if (prodOpt.isPresent()) {
			ProductItem managedProductItem = prodOpt.get();
			managedProductItem.setQuality(productItem.getQuality());
			managedProductItem.setAvailable(productItem.getAvailable());
			repo.saveAndFlush(managedProductItem);
			return managedProductItem;
		}
		return productItem;
	}
}






