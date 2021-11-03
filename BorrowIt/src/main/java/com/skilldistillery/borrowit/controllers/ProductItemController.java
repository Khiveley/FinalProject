package com.skilldistillery.borrowit.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.borrowit.entities.ProductItem;
import com.skilldistillery.borrowit.entities.User;
import com.skilldistillery.borrowit.services.ProductItemService;
import com.skilldistillery.borrowit.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4301" })
public class ProductItemController {
	
	@Autowired
	private ProductItemService prodItemSvc;

	@Autowired
	private UserService userSvc;

	@GetMapping("productitems/{id}")
	public ProductItem getProductItemById(@PathVariable Integer id) {
		return prodItemSvc.getProductItemById(id);
	}

	@GetMapping("productitems")
	public List<ProductItem> getAllProductItems() {
		return prodItemSvc.getAll();
	}
	
	@GetMapping("productitems/available")
	public List<ProductItem> getAllProductItemsAvailable() {
		return prodItemSvc.getAllAvailableProductItems();
	}

	@PostMapping("productitems")
	public ProductItem createProductItem(Principal principal, @RequestBody ProductItem productItem) {
		String username = principal.getName();
		User user=userSvc.getUserByName(username);
		productItem.setUser(user);
		return prodItemSvc.createProductItem(productItem);
	}

	@PutMapping("productitems/{id}")
	public ProductItem update(HttpServletRequest req, HttpServletResponse res, @PathVariable int id, @RequestBody ProductItem productItem,
			Principal principal) {
		try {
			productItem = prodItemSvc.updateProductItem(id, productItem);
			if (productItem == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			res.setStatus(400);
			productItem = null;
			e.printStackTrace();
		}
		return productItem;
	}
}

