package com.skilldistillery.borrowit.services;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import com.skilldistillery.borrowit.entities.Borrow;

public interface BorrowService {

	List<Borrow> index();

	Borrow show(String name, int bid);


	boolean destroy(String name, int bid);

	Borrow update(String name, int bid, Borrow borrow);


	Borrow create(String name, Borrow borrow);

}
