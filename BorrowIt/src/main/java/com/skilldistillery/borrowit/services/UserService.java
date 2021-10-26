package com.skilldistillery.borrowit.services;

import com.skilldistillery.borrowit.entities.User;

public interface UserService {
	
	User getUserByName(String username);

}
