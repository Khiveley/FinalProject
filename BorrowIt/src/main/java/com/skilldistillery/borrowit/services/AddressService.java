package com.skilldistillery.borrowit.services;

import java.util.List;

import com.skilldistillery.borrowit.entities.Address;
import com.skilldistillery.borrowit.entities.Product;

public interface AddressService {

	List<Address> index();

	Address show(int id);

	Address create(Address address);

	Address update(Integer id, Address address);

	boolean destroy(Integer id);

}
