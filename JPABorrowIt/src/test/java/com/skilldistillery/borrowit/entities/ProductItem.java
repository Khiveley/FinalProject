package com.skilldistillery.borrowit.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductItem {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private ProductItem productItem;

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
		productItem = em.find(ProductItem.class, 1);
	}


	@AfterEach
	void tearDown() throws Exception {
		em.close();
		productItem = null;
	}


	@Test
	void test() {
		assertNotNull(productItem);
		assertEquals();
		assertEquals();
		assertEquals();
		assertEquals();
	}

}
