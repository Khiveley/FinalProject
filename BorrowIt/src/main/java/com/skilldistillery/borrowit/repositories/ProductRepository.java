package com.skilldistillery.borrowit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.borrowit.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	public Product queryById(int productId);

	public List<Product> findByUser_Username(String username);

	public Product findByUser_UsernameAndId(String username, int id);
	
//add enabled to db. use instead of findall	public List <Product> findByEnabled();

}
