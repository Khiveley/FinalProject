package com.skilldistillery.borrowit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.borrowit.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
	
	public List<Rating> findByProduct_Id (int productId);

}
