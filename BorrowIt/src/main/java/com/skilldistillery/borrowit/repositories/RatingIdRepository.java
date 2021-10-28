package com.skilldistillery.borrowit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.borrowit.entities.RatingId;

public interface RatingIdRepository extends JpaRepository<RatingId, Integer> {

}
