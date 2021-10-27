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

class ProductTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Product product;

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
		product = em.find(Product.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		product = null;
	}

	@Test
	void test() {
//		+----+----------+------------------------------------------------------------------------+----------------------------------------------------------------+-------------+
//		| id | title    | description                                                            | image_url                                                      | category_id |
//		+----+----------+------------------------------------------------------------------------+----------------------------------------------------------------+-------------+
//		|  1 | Monopoly | A family friendly game that most definitely won't end any friendships! | https://m.media-amazon.com/images/I/91RSg9MCGtL._AC_SY450_.jpg |           1 |

		assertNotNull(product);
		assertEquals("Monopoly", product.getTitle());
		assertEquals("A family friendly game that most definitely won't end any friendships!", product.getDescription());
		assertEquals("https://m.media-amazon.com/images/I/91RSg9MCGtL._AC_SY450_.jpg", product.getImageUrl());
		assertEquals(1, categoryId());
	}

}
