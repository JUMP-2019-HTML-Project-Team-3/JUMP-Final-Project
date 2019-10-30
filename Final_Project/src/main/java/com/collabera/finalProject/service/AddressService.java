package com.collabera.finalProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.model.Address;
import com.collabera.finalProject.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	
	//Constructor
	public AddressService(AddressRepository addressRepository) {
		
		this.addressRepository = addressRepository;
	}

	//Add
	public void addAddress(String streetNumber, String streetName, String suiteNo, 
			String township, String state, String zip, String country) {

		Address template = new Address();

		template.setStreetNumber(streetNumber);
		template.setStreetName(streetName);
		template.setSuiteNo(suiteNo);
		template.setTownship(township);
		template.setState(state);
		template.setZip(zip);
		template.setCountry(country);
		
		addressRepository.save(template);
	}

	//Find By Id
	public Optional<Address> getAddressById(Long id) {

		return addressRepository.findById(id);
		
	}

	//Find All
	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	//Update
	public void updateAddress(Address address) {
		Optional<Address> findById = addressRepository.findById(address.getId());
		if (findById.isPresent()) {
			Address addressUpdate = findById.get();

			addressUpdate.setStreetNumber(address.getStreetNumber());
			addressUpdate.setStreetName(address.getStreetName());
			addressUpdate.setSuiteNo(address.getSuiteNo());
			addressUpdate.setTownship(address.getTownship());
			addressUpdate.setState(address.getState());
			addressUpdate.setZip(address.getZip());
			addressUpdate.setCountry(address.getCountry());
			
			addressRepository.save(addressUpdate);
		}
		else throw new IllegalArgumentException();
	}

	//Delete
	public void deleteAddress(Long id) { addressRepository.deleteById(id); }
}
