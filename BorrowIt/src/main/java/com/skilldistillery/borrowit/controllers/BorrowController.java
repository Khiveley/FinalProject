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

import com.skilldistillery.borrowit.entities.Borrow;
import com.skilldistillery.borrowit.services.BorrowService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4301" })
public class BorrowController {

	@Autowired
	private BorrowService borrowSvc;
	
	@GetMapping("borrows")
	public List<Borrow> index(HttpServletRequest req, HttpServletResponse res) {
		return borrowSvc.index();
	}

	@GetMapping("borrows/{bid}")
	public Borrow show(HttpServletRequest req,
			HttpServletResponse res,@PathVariable int bid, Principal principal) {
		
		Borrow borrow = borrowSvc.show(bid);
		if(borrow == null) {
			res.setStatus(404);
		}
		return borrow;
	}
	
	//POST

	@PostMapping("productitems")
	public Borrow create(HttpServletRequest req, HttpServletResponse res,
			@RequestBody Borrow borrow, int productItemId) {
		
		
		borrow =	borrowSvc.create(borrow);
		if( borrow == null) {
			res.setStatus(400);
		}
		return borrow;
	}

	@PutMapping("productitems/{bid}")
	public Borrow update(HttpServletRequest req, 
			HttpServletResponse res,
			@PathVariable int bid, 
			@RequestBody Borrow borrow,
			Principal principal) {
		
		borrow= borrowSvc.update(bid, borrow);
		if(borrow == null)
		{		
			res.setStatus(404);
		}
		return borrow;
	}

	@DeleteMapping("productitems/{bid}")
	public void destroy(HttpServletRequest req, HttpServletResponse res,
			@PathVariable int bid, Principal principal) {
		if(borrowSvc.destroy(principal.getName(), bid)) {
			res.setStatus(204);
		}else {
			res.setStatus(404);
		}
		
	}

	
	
	
	
	
	
	
	
}
