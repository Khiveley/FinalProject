package com.skilldistillery.borrowit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.borrowit.entities.User;
import com.skilldistillery.borrowit.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User getUserByName(String username) {
		return userRepo.findByUsername(username);
	}

}
