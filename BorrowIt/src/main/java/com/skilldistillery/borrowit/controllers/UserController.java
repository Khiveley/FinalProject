package com.skilldistillery.borrowit.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.borrowit.entities.User;
import com.skilldistillery.borrowit.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4301"})
public class UserController {
	
	@Autowired
	private UserService userSvc;
	
	@GetMapping("ping")
	public String ping() {
		return "pong";
	}
	
	// Principal is for anything that needs authentication i.e. not gets

	@GetMapping(path = "users")
	public List<User> index(
			HttpServletRequest req, 
			HttpServletResponse res) {
		List<User> users = userSvc.index();
		if (users == null) {
			res.setStatus(404);
		}
		return users;
	}

	@GetMapping(path = "users/{id}")
	public User show(
			HttpServletRequest req, 
			HttpServletResponse res, 
			@PathVariable int id) {
		User user = userSvc.show(id);
		if (user == null) {
			res.setStatus(404);
		}
		return user;
	}

	@PostMapping("users")
	public User create(
			HttpServletRequest req, 
			HttpServletResponse res, 
			@RequestBody User user) {
		 user = userSvc.create(user);
		 if (user == null) {
			 res.setStatus(400);
		 }
		 return user;
	}

	@PutMapping("users/{id}")
	public User update(
			HttpServletRequest req, 
			HttpServletResponse res,
			@PathVariable int id,
			@RequestBody User user) {
		user = userSvc.update(id, user);
		 if (user == null) {
			 res.setStatus(400);
		 }
		 return user;
	}

}
