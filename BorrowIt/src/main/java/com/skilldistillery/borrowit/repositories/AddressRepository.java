package com.skilldistillery.borrowit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.borrowit.entities.Address;
import com.skilldistillery.borrowit.entities.User;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
