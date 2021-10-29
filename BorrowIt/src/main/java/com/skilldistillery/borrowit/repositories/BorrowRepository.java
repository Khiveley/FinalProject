package com.skilldistillery.borrowit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.borrowit.entities.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, Integer> {

	List<Borrow> findByUser_Username(String username);
	
	Borrow findByUser_UsernameAndId(String username, int bid);
}
