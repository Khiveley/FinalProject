package com.skilldistillery.borrowit.services;

import java.util.List;

import com.skilldistillery.borrowit.entities.Category;

public interface CategoryService {
	public Category findById (int id);
	public List<Category> showAllCategories();

}
