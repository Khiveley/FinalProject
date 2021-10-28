package com.skilldistillery.borrowit.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.borrowit.entities.Category;
import com.skilldistillery.borrowit.services.CategoryService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4301"})
public class CategoryController {
	
	@Autowired
	private CategoryService svc;
	
	@GetMapping(path="category/{id}")
	public Category getCategory(@PathVariable Integer id, HttpServletResponse rsp) {
		Category category = svc.findById(id);
		if (category == null) {
			rsp.setStatus(404);
		} else {
			rsp.setStatus(201);
		}
		return category;
	}
	
	@GetMapping(path="category")
	public List<Category> allCategories() {
		return svc.showAllCategories();
	}
	

}
