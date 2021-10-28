package com.skilldistillery.borrowit.services;

import org.springframework.stereotype.Service;

import com.skilldistillery.borrowit.entities.User;


public interface AuthService {
	public User register(User user);
	
	public User getUser(String username);

}