package com.skilldistillery.borrowit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.borrowit.entities.Borrow;
import com.skilldistillery.borrowit.repositories.BorrowRepository;


@Service
public class BorrowServiceImpl implements BorrowService{
	
	@Autowired
	private BorrowRepository borrowRepo;

	@Override
	public List<Borrow> index() {

		return borrowRepo.findAll();
	}

	@Override
	public Borrow show(String name, int bid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Borrow create(String name, Borrow borrow) { 
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean destroy(String name, int bid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Borrow update(String name, int bid, Borrow borrow) {
		// TODO Auto-generated method stub
		return null;
	}


}
