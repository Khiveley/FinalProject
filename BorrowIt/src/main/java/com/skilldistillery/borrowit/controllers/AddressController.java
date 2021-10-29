package com.skilldistillery.borrowit.controllers;

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

import com.skilldistillery.borrowit.entities.Address;
import com.skilldistillery.borrowit.entities.Product;
import com.skilldistillery.borrowit.services.AddressService;

	@RestController
	@RequestMapping("api")
	@CrossOrigin({ "*", "http://localhost:4301" })
	public class AddressController {
		
		@Autowired
		public AddressService addSvc;

		@GetMapping("addresses")
		public List<Address> index(HttpServletRequest req,
				HttpServletResponse res
				) {
			return addSvc.index();

		}
		
		@GetMapping("addresses/{id}")
		public Address show(HttpServletRequest req,
				HttpServletResponse res,
				@PathVariable int id
				) {
			return addSvc.show(id);
		}

		@PostMapping("addresses")
		public Address create(HttpServletRequest req,
				HttpServletResponse res,
				@RequestBody Address address
				) {
			
			address = addSvc.create(address);
			if (address == null) {
				res.setStatus(400);
			}
			return address;
		}
		
		@PutMapping("addresses/{id}")
		public Address update(HttpServletRequest req,
				HttpServletResponse res,
				@PathVariable int id,
				@RequestBody Address address
				) {
			address = addSvc.update(id, address);
			if (address == null) {
				res.setStatus(400);
			}
			return address;
		}

		@DeleteMapping("addresses/{id}")
		public boolean destroy(HttpServletRequest req,
				HttpServletResponse res,
				@PathVariable int id
				) {
			addSvc.destroy(id);
			
			return true;
		}
		
		

}
