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

	@Test
	void ManyToOne_ProductItem_to_Product_entity_test() {
		
//	select *  from product p join product_item i on p.id = i.product_id where p.id = 1;
//	+----+----------+------------------------------------------------------------------------+----------------------------------------------------------------+-------------+----+---------+------------+---------+---------+
//	| id | title    | description                                                            | image_url                                                      | category_id | id | quality | product_id | user_id | version |
//	+----+----------+------------------------------------------------------------------------+----------------------------------------------------------------+-------------+----+---------+------------+---------+---------+
//	|  1 | Monopoly | A family friendly game that most definitely won't end any friendships! | https://m.media-amazon.com/images/I/91RSg9MCGtL._AC_SY450_.jpg |           1 |  1 | Mint    |          1 |       1 | Classic |
//	+----+----------+------------------------------------------------------------------------+----------------------------------------------------------------+-------------+----+---------+------------+---------+---------+
	
		assertNotNull(productItem);
		assertNotNull(productItem.getProduct());
		assertEquals("Monopoly", productItem.getProduct().getTitle());
		assertEquals("A family friendly game that most definitely won't end any friendships!", productItem.getProduct().getDescription());
		assertEquals("https://m.media-amazon.com/images/I/91RSg9MCGtL._AC_SY450_.jpg", productItem.getProduct().getImageUrl());
		assertEquals(1, productItem.getProduct().getCategory().getId());
	}
	
	@Test
	void ManyToOne_ProductItem_to_User_entity_test() {
		
//	select *  from user u  join product_item i on u.id = i.product_id where u.id = 1;
//	+----+----------+----------+------------+-----------+---------------------------+-------------+------------+---------+------------+----------------------------------------------------------------+----+---------+------------+---------+---------+
//	| id | username | password | first_name | last_name | email                     | create_date | address_id | enabled | role       | profile_image                                                  | id | quality | product_id | user_id | version |
//	+----+----------+----------+------------+-----------+---------------------------+-------------+------------+---------+------------+----------------------------------------------------------------+----+---------+------------+---------+---------+
//	|  1 | admin    | admin    | Ken        | Hiveley   | kenneth.hiveley@gmail.com | NULL        |          1 |       1 | ROLE_ADMIN | https://m.media-amazon.com/images/I/91RSg9MCGtL._AC_SY450_.jpg |  1 | Mint    |          1 |       1 | Classic |
//	+----+----------+----------+------------+-----------+---------------------------+-------------+------------+---------+------------+----------------------------------------------------------------+----+---------+------------+---------+---------+
	
		assertNotNull(productItem);
		assertNotNull(productItem.getUser());
		assertEquals("admin", productItem.getUser().getUsername());
		assertEquals("admin", productItem.getUser().getPassword());
		assertEquals("Ken", productItem.getUser().getFirstName());
		assertEquals("Hiveley", productItem.getUser().getLastName());
		assertEquals("kenneth.hiveley@gmail.com", productItem.getUser().getEmail());
		assertEquals("ROLE_ADMIN", productItem.getUser().getRole());
		assertEquals(null, productItem.getUser().getCreateDate());
		assertEquals(1, productItem.getUser().getAddress().getId());
		assertEquals(true, productItem.getUser().getEnabled());
		assertEquals("https://m.media-amazon.com/images/I/91RSg9MCGtL._AC_SY450_.jpg", productItem.getUser().getProfileImage());
	}
}
