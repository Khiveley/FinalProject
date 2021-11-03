package com.skilldistillery.borrowit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.borrowit.entities.Borrow;
import com.skilldistillery.borrowit.entities.ProductItem;
import com.skilldistillery.borrowit.repositories.BorrowRepository;
import com.skilldistillery.borrowit.repositories.UserRepository;

@Service
public class BorrowServiceImpl implements BorrowService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BorrowRepository borrowRepo;

	@Override
	public List<Borrow> index() {

		return borrowRepo.findAll();
	}

	@Override
	public Borrow show(int bid) {
		Optional<Borrow> borrowOp = borrowRepo.findById(bid);
		if (borrowOp.isPresent()) {
			return borrowOp.get();
		}
		return null;
	}
	
//	`Borrow`            |`POST api/productitems`       | Create a borrow                         |
//	|`Borrow`            |`PUT api/productitems/{id}`   | Replace an existing borrow by id        |
//	|`void`              |`DELETE api/productitems/{id}`| Delete an existing borrow by id       


	@Override
	public boolean destroy(String name, int bid) {
//borrow doesnt need a delete
		return false;
	}

	@Override
	public Borrow update(int bid, Borrow borrow) {
		borrowRepo.save(borrow);

		return borrow;
	}

	@Override
	public Borrow create(ProductItem productItem, String username) {
		Borrow borrow = new Borrow();
		borrow.setId(0);
		borrow.setProductItem(productItem.getId());
		borrow.setBorrowerId(userRepo.findByUsername(username).getId());
		borrow.setUser(productItem.getUser());
		return borrowRepo.saveAndFlush(borrow);
	}
	

}
