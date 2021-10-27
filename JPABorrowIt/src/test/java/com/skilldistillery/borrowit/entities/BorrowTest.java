package com.skilldistillery.borrowit.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BorrowTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Borrow borrow;

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
		borrow = em.find(Borrow.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		borrow = null;
	}

	@Test
	void test_User_entitiy_mapping() {
		assertNotNull(borrow);
		assertEquals(3, borrow.getBorrowRating());
	}

}
