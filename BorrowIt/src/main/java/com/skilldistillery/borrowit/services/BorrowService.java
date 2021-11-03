package com.skilldistillery.borrowit.services;

import java.util.List;

import com.skilldistillery.borrowit.entities.Borrow;
import com.skilldistillery.borrowit.entities.ProductItem;

public interface BorrowService {

	List<Borrow> index();

	Borrow show(int bid);


	boolean destroy(String name, int bid);

	Borrow update(int bid, Borrow borrow);


	Borrow create(ProductItem productItem, String username);

}
