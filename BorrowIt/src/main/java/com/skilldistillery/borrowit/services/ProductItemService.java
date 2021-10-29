package com.skilldistillery.borrowit.services;

import java.util.List;

import com.skilldistillery.borrowit.entities.ProductItem;

public interface ProductItemService {

	ProductItem getProductItemById(Integer id);

	List<ProductItem> getAll();

	List<ProductItem> getAllAvailableProductItems();

	ProductItem createProductItem(ProductItem productItem);

	ProductItem updateProductItem(int id, ProductItem productItem);

}
