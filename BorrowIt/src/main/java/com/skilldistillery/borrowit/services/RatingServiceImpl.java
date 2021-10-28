package com.skilldistillery.borrowit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.borrowit.entities.Product;
import com.skilldistillery.borrowit.entities.Rating;
import com.skilldistillery.borrowit.entities.RatingId;
import com.skilldistillery.borrowit.entities.User;
import com.skilldistillery.borrowit.repositories.ProductRepository;
import com.skilldistillery.borrowit.repositories.RatingRepository;
import com.skilldistillery.borrowit.repositories.UserRepository;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository repo;
	
	@Override
	public Rating createRating(String username, Rating rating, int productId) {
		User user = userRepo.findByUsername(username);
		Product p = prodRepo.queryById(productId);
		if (user != null && p!= null) {
			RatingId ratingId = new RatingId(user.getId(), productId);
			rating.setId(ratingId);
			rating.setProduct(p);
			rating.setUser(user);
			repo.saveAndFlush(rating);
			return rating;
		} else {
		return null;
	}
	}
	
	@Override
	public List<Rating> getProductRatings(int productId) {
		if (prodRepo.existsById(productId)) {
		return repo.findByProduct_Id(productId);
		} else {
			return null;
		}
	}
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProductRepository prodRepo;
	

}
