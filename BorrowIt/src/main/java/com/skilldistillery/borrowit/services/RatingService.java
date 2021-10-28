package com.skilldistillery.borrowit.services;

import java.util.List;

import com.skilldistillery.borrowit.entities.Rating;

public interface RatingService {

	List<Rating> getProductRatings(int productId);

	Rating createRating(String username, Rating rating, int productId);

}
