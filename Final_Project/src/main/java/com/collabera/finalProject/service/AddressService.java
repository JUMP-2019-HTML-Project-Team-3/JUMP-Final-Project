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
	
	public void addAddress(Long id, String streetNumber, String streetName, String suiteNo, 
			String township, String state, String zip, String country) {

		Address template = new Address();

		template.setId(id);
		template.setStreetNumber(streetNumber);
		template.setStreetName(streetName);
		template.setSuiteNo(suiteNo);
		template.setTownship(township);
		template.setState(state);
		template.setZip(zip);
		template.setCountry(country);
	}

	public Address getAddressById(Long id) {
		try {
			Optional<Address> AddressOpt = addressRepository.findById(Integer.parseInt(id));
			if(AddressOpt.isPresent()) return AddressOpt.get();
		}
		catch(Exception e) {}
		return null;
	}

	public List<Address> findAll() {
		return addressRepository.findAll();
	}

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
		}
		else throw new IllegalArgumentException();
	}

	public void deleteAddress(Long id) { addressRepository.deleteById(id); }
}
