package com.skilldistillery.borrowit.services;

import java.util.List;
import java.util.Set;

import com.skilldistillery.borrowit.entities.Borrow;

public interface BorrowService {


	Borrow show(String name, int bid);

	Borrow create(String name, Borrow borrow);

	boolean destroy(String name, int bid);

	Borrow update(String name, int bid, Borrow borrow);

}
