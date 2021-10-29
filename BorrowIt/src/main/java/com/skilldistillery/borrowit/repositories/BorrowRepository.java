package com.skilldistillery.borrowit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.borrowit.entities.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, Integer> {

}