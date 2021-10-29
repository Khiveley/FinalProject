package com.skilldistillery.borrowit.services;

import java.util.List;

import com.skilldistillery.borrowit.entities.User;

public interface UserService {
	
	User getUserByName(String username);
	
	  public List<User> index();

	    public User show(int id);

	    public User create(User user);

	    public User update(int id, User user);

	

}
