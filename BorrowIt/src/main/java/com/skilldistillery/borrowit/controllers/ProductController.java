package com.skilldistillery.borrowit.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.borrowit.entities.Product;
import com.skilldistillery.borrowit.services.ProductService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4301" })
public class ProductController {

	@Autowired
	public ProductService prodSvc;

	@GetMapping("products")
	public List<Product> index(HttpServletRequest req,
			HttpServletResponse res
			) {
		return prodSvc.index();

	}

	@GetMapping("products/{id}")
	public Product show(HttpServletRequest req,
			HttpServletResponse res,
			@PathVariable int id
			) {
		return prodSvc.show(id);
	}

	@PostMapping("products")
	public Product create(HttpServletRequest req,
			HttpServletResponse res,
			@RequestBody Product product
			) {
		
		product = prodSvc.create(product);
		if (product == null) {
			res.setStatus(400);
		}
		return product;
	}

	@PutMapping("products/{id}")
	public Product update(HttpServletRequest req,
			HttpServletResponse res,
			@PathVariable int id,
			@RequestBody Product product
			) {
		product = prodSvc.update(id, product);
		if (product == null) {
			res.setStatus(400);
		}
		return product;
	}

	@DeleteMapping("products/{id}")
	public boolean destroy(HttpServletRequest req,
			HttpServletResponse res,
			@PathVariable int id
			) {
		prodSvc.destroy(id);
		
		return true;
	}
}

