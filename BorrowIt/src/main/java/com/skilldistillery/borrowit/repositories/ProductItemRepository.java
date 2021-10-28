package com.skilldistillery.borrowit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.borrowit.entities.ProductItem;

public interface ProductItemRepository extends JpaRepository<ProductItem, Integer> {

}
