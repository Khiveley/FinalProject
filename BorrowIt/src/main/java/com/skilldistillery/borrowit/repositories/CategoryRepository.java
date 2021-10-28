package com.skilldistillery.borrowit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.borrowit.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>  {

}
