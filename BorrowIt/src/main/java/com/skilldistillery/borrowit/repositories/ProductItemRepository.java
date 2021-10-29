package com.skilldistillery.borrowit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.borrowit.entities.ProductItem;

public interface ProductItemRepository extends JpaRepository<ProductItem, Integer> {

	List<ProductItem> findByAvailable(boolean b);

}
