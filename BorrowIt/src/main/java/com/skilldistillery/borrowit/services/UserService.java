package com.skilldistillery.borrowit.services;

import java.security.Principal;
import java.util.List;

import com.skilldistillery.borrowit.entities.User;

public interface UserService {
	
	User getUserByName(String username);
	
	  public List<User> index();

	    public User show(int id);

	    public User create(Principal principal, User user);

	    public User update(Principal principal, int id, User user);

	    public boolean destroy(Principal principal, int id);

}
