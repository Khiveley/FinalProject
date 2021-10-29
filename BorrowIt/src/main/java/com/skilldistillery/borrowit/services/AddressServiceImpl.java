package com.skilldistillery.borrowit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.borrowit.entities.Address;
import com.skilldistillery.borrowit.entities.Product;
import com.skilldistillery.borrowit.repositories.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	AddressRepository addRepo;

	@Override
	public List<Address> index() {
		return addRepo.findAll();
	}

	@Override
	public Address show(int addressId) {
		Optional<Address> addOpt = addRepo.findById(addressId);
		return addOpt.get();
	}

	@Override
	public Address create(Address address) {
		addRepo.saveAndFlush(address);
		return address;
	}

	@Override
	public Address update(Integer id, Address address) {
		Optional<Address> addOpt= addRepo.findById(id);
		
		if(addOpt.isPresent()) {
			Address managedAddress = addOpt.get();
			managedAddress.setCity(address.getCity());
			managedAddress.setState(address.getState());
			managedAddress.setZip(address.getZip());
			addRepo.saveAndFlush(managedAddress);
			return managedAddress;
	}
		return null;
	}
	
	@Override
	public boolean destroy(Integer id) {
		Optional<Address> addOpt= addRepo.findById(id);
		
		if(addOpt.isPresent()) {
			Address managedAddress = addOpt.get();
			addRepo.saveAndFlush(managedAddress);
			return true;
	}
		return false;
	}


}
