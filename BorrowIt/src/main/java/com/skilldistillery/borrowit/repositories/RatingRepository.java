package com.skilldistillery.borrowit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.borrowit.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
