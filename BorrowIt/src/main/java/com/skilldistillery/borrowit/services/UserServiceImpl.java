package com.skilldistillery.borrowit.services;

import java.security.Principal;
import java.util.List;

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
		return userRepo.getById(id);
	}

	@Override
	public User create(Principal principal, User user) {
		return userRepo.saveAndFlush(user);
	}

	@Override
	public User update(Principal principal, int id, User user) {
		// TODO Auto-generated method stub
		User currentUser = userRepo.getById(id);
		if (currentUser != null) {
			currentUser.setAddress(user.getAddress());
			currentUser.setBorrows(user.getBorrows());
			currentUser.setUsername(user.getUsername());
			currentUser.setPassword(user.getPassword());
			currentUser.setEnabled(user.getEnabled());
			currentUser.setEmail(user.getEmail());
			currentUser.setRole(user.getRole());
			currentUser.setRatings(user.getRatings());
			currentUser.setProducts(user.getProducts());
			currentUser.setFirstName(user.getFirstName());
			currentUser.setLastName(user.getLastName());
			currentUser.setProfileImage(user.getProfileImage());
			currentUser.setCreateDate(user.getCreateDate());
			userRepo.saveAndFlush(currentUser);
			return currentUser;
		}
		return null;
	}

	@Override
	public boolean destroy(Principal principal, int id) {
		User savedUser = userRepo.getById(id);
		userRepo.deleteById(id);
		if (savedUser !=null) {
			return false;
		} else {
			return true;
		}
	}

}
