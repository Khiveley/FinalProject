package com.skilldistillery.borrowit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.borrowit.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userSvc;
	

}
