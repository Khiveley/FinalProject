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

class AddressTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Address address;

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
		address = em.find(Address.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		address = null;
	}
	
	//+----+-----------+-------+------+
//	| id | city      | state | zip  |
//	+----+-----------+-------+------+
//	|  1 | Whereever | CO    |    0 |

	@Test
	void test_User_entitiy_mapping() {
		assertNotNull(address);
		assertEquals("Whereever", address.getCity());
		assertEquals("CO", address.getState());
		assertEquals(0, address.getZip());
	}

}
