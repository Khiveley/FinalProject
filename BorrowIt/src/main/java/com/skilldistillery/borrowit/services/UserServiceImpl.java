package com.skilldistillery.borrowit.services;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<User> index() {
		return userRepo.findAll();
	}

	@Override
	public User show(int id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public User create(User user) {
		return userRepo.saveAndFlush(user);
	}


	@Override
	public User update(int id, User user) {
		Optional<User> savedUser = userRepo.findById(id);
		User updatedUser = null;
		if (savedUser.isPresent()) {
			updatedUser = savedUser.get();
			updatedUser.setAddress(user.getAddress());
			updatedUser.setBorrows(user.getBorrows());
			updatedUser.setUsername(user.getUsername());
			updatedUser.setPassword(user.getPassword());
			updatedUser.setEnabled(user.getEnabled());
			updatedUser.setEmail(user.getEmail());
			updatedUser.setRole(user.getRole());
			updatedUser.setRatings(user.getRatings());
			updatedUser.setProducts(user.getProducts());
			updatedUser.setFirstName(user.getFirstName());
			updatedUser.setLastName(user.getLastName());
			updatedUser.setProfileImage(user.getProfileImage());
			updatedUser.setCreateDate(user.getCreateDate());
			userRepo.saveAndFlush(updatedUser);
			return updatedUser;
		}
		return null;
	}


}
