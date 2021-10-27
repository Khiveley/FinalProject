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

class ProductItemTest {

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
		
//		+----+---------+------------+---------+----------------+
//		| id | quality | product_id | user_id | version        |
//		+----+---------+------------+---------+----------------+
//		|  1 | Mint    |          1 |       1 | Classic        |
//		|  2 | Used    |          2 |       3 | DVD            |
//		|  3 | Used    |          3 |       4 | Standard       |
//		|  4 | New     |          4 |       4 | Deluxe Edition |
//		|  5 | Used    |          5 |       3 | Classic        |
//		+----+---------+------------+---------+----------------+
		assertNotNull(productItem);
		assertEquals("Mint", productItem.getQuality());
		assertEquals(1, productItem.getProduct().getId());
		assertEquals(1, productItem.getUser().getId());
		assertEquals("Classic", productItem.getVersion());
	}

//	+----+----------+------------------------------------------------------------------------+----------------------------------------------------------------+-------------+----+---------+------------+---------+---------+
//	| id | title    | description                                                            | image_url                                                      | category_id | id | quality | product_id | user_id | version |
//	+----+----------+------------------------------------------------------------------------+----------------------------------------------------------------+-------------+----+---------+------------+---------+---------+
//	|  1 | Monopoly | A family friendly game that most definitely won't end any friendships! | https://m.media-amazon.com/images/I/91RSg9MCGtL._AC_SY450_.jpg |           1 |  1 | Mint    |          1 |       1 | Classic |
//	+----+----------+------------------------------------------------------------------------+----------------------------------------------------------------+-------------+----+---------+------------+---------+---------+
}
