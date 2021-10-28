package com.skilldistillery.borrowit.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
//		SELECT * from product where id = 1;
//		+----+----------+------------------------------------------------------------------------+----------------------------------------------------------------+-------------+
//		| id | title    | description                                                            | image_url                                                      | category_id |
//		+----+----------+------------------------------------------------------------------------+----------------------------------------------------------------+-------------+
//		|  1 | Monopoly | A family friendly game that most definitely won't end any friendships! | https://m.media-amazon.com/images/I/91RSg9MCGtL._AC_SY450_.jpg |           1 |

		assertNotNull(product);
		assertEquals("Monopoly", product.getTitle());
		assertEquals("A family friendly game that most definitely won't end any friendships!",
				product.getDescription());
		assertEquals("https://m.media-amazon.com/images/I/91RSg9MCGtL._AC_SY450_.jpg", product.getImageUrl());
		assertEquals(1, product.getCategory().getId());
	}
	
	@Test
	
	void test_OneToMany_product_to_productItems() {
		
//		select *  from product p  join product_item i on p.id = i.product_id where p.id = 1;
//		+----+----------+------------------------------------------------------------------------+----------------------------------------------------------------+-------------+----+---------+------------+---------+---------+
//		| id | title    | description                                                            | image_url                                                      | category_id | id | quality | product_id | user_id | version |
//		+----+----------+------------------------------------------------------------------------+----------------------------------------------------------------+-------------+----+---------+------------+---------+---------+
//		|  1 | Monopoly | A family friendly game that most definitely won't end any friendships! | https://m.media-amazon.com/images/I/91RSg9MCGtL._AC_SY450_.jpg |           1 |  1 | Mint    |          1 |       1 | Classic |
//		+----+----------+------------------------------------------------------------------------+----------------------------------------------------------------+-------------+----+---------+------------+---------+---------+
		
		assertNotNull(product);
		assertNotNull(product.getProductItems());
		assertTrue(product.getProductItems().size()>0);
		assertEquals(1, product.getProductItems().size());
	}

	@Test
	
	void test_ManyToOne_Product_to_Category() {
		
//		select * from product p join category c on p.id = c.id where p.id = 1;
//		+----+----------+------------------------------------------------------------------------+----------------------------------------------------------------+-------------+----+------------+
//		| id | title    | description                                                            | image_url                                                      | category_id | id | category   |
//		+----+----------+------------------------------------------------------------------------+----------------------------------------------------------------+-------------+----+------------+
//		|  1 | Monopoly | A family friendly game that most definitely won't end any friendships! | https://m.media-amazon.com/images/I/91RSg9MCGtL._AC_SY450_.jpg |           1 |  1 | Board Game |
//		+----+----------+------------------------------------------------------------------------+----------------------------------------------------------------+-------------+----+------------+
		
		assertNotNull(product);
		assertNotNull(product.getCategory());
		assertEquals(1, product.getCategory().getId());
	}
	
	@Test
	
	void test_OneToMany_Product_to_Rating() {
		
//		select * from rating r join product p on p.id = r.product_id where r.product_id = 1;
//		+--------+----------------+---------+------------+----+----------+------------------------------------------------------------------------+----------------------------------------------------------------+-------------+
//		| rating | rating_comment | user_id | product_id | id | title    | description                                                            | image_url                                                      | category_id |
//		+--------+----------------+---------+------------+----+----------+------------------------------------------------------------------------+----------------------------------------------------------------+-------------+
//		|      4 | NULL           |       1 |          1 |  1 | Monopoly | A family friendly game that most definitely won't end any friendships! | https://m.media-amazon.com/images/I/91RSg9MCGtL._AC_SY450_.jpg |           1 |
//		+--------+----------------+---------+------------+----+----------+------------------------------------------------------------------------+----------------------------------------------------------------+-------------+

		assertNotNull(product);
		assertNotNull(product.getRatings());
		assertTrue(product.getRatings().size()>0);
		assertEquals(1, product.getRatings().size());
	}
	
}
