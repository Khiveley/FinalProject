package com.skilldistillery.borrowit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.borrowit.entities.Rating;
import com.skilldistillery.borrowit.services.RatingService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4301" })
public class RatingController {
	
	@Autowired
	private RatingService svc;
	
	@GetMapping("products/{productId}/ratings")
	public List<Rating> getRatings (@PathVariable int productId) {
		List<Rating> ratings = svc.getProductRatings(productId);
		return ratings;
	}
}






// 