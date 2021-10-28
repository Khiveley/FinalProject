package com.skilldistillery.borrowit.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPABorrowIt");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
	}

	@Test
	void test_user_entitiy_mapping() {
		assertNotNull(user);
		assertEquals("admin", user.getUsername());
	}
	
	@Test
	void test_user_address_relationship() {
		assertNotNull(user);
		assertEquals("CO", user.getAddress().getState());
		assertEquals("Whereever", user.getAddress().getCity());
	}
	
	@Test
	void test_user_borrow_relationship() {
		assertNotNull(user);
		assertEquals(1, user.getBorrows().size());
	}
	
	@Test
	void test_user_rating_relationship() {
		assertNotNull(user);
		assertEquals(1, user.getRatings().size());
	}
	
	@Test
	void test_user_productItem_relationship() {
		assertNotNull(user);
		assertEquals(1, user.getProducts().size());
	}
	
	
	

}
