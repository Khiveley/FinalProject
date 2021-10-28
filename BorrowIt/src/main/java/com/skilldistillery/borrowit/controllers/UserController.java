package com.skilldistillery.borrowit.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
		User User = userSvc.show(id);
		if (User == null) {
			res.setStatus(404);
		}
		return User;
	}

	@PostMapping("users")
	public User create(
			HttpServletRequest req, 
			HttpServletResponse res, 
			@RequestBody User User, 
			Principal principal) {
		 User = userSvc.create(principal, User);
		 if (User == null) {
			 res.setStatus(400);
		 }
		 return User;
	}

	@PutMapping("users/{id}")
	public User update(
			HttpServletRequest req, 
			HttpServletResponse res,
			@PathVariable int id,
			@RequestBody User User, 
			Principal principal) {
		User = userSvc.update(principal, id, User);
		 if (User == null) {
			 res.setStatus(400);
		 }
		 return User;
	}

	@DeleteMapping("users/{id}")
	public void destroy(
			HttpServletRequest req, 
			HttpServletResponse res, 
			@PathVariable int id, 
			Principal principal) {
		if (userSvc.destroy(principal, id)) {
		res.setStatus(204);
	} else {
		res.setStatus(404);
	}
	}

}
