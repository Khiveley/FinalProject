package com.skilldistillery.borrowit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.borrowit.entities.Borrow;
import com.skilldistillery.borrowit.repositories.BorrowRepository;

@Service
public class BorrowServiceImpl implements BorrowService {

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

	@Override
	public Borrow create(Borrow borrow) {
		borrowRepo.save(borrow);
		return borrow;
	}

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

}
