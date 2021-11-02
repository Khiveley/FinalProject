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

class RatingTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Rating rating;

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
		RatingId rid = new RatingId();
		rid.setProductId(1);
		rid.setUserId(1);
		rating = em.find(Rating.class, rid);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		rating = null;
	}

	@Test
	void test() {
		assertNotNull(rating);
		assertEquals(7, rating.getRating());
		
	}
	
	@Test
	void test_rating_user_relationship_mapping() {
		assertNotNull(rating);
		assertEquals(1, rating.getId().getUserId());
		
	}
	@Test
	void test_rating_product_relationship_mapping() {
		assertNotNull(rating);
		assertEquals(1, rating.getId().getProductId());
		
	}

	
	

}
