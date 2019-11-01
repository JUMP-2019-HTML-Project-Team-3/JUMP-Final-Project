package com.collabera.finalProject.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.finalProject.dto.AddressDTO;
import com.collabera.finalProject.mapper.Mapper;
import com.collabera.finalProject.model.Address;
import com.collabera.finalProject.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private Mapper mapper = new Mapper();
	
	
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
	}

	//Find By Id
	public Optional<AddressDTO> getAddressById(Long id) {

		// Set Mapper View
		mapper.setAddressView(true);
		// Retrieve, set to Optional in order to use Repository functions, then to DTO
		return Optional.of(mapper.AddressToDTO(addressRepository.findById(id).get()));
		
	}

	//Find All
	public List<AddressDTO> findAll() {
		// Set View for mapper
		mapper.setAddressView(true);
		
		return addressRepository.findAll().stream().map(m -> mapper.AddressToDTO(m)).collect(Collectors.toList());
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
		}
		else throw new IllegalArgumentException();
	}

	//Delete
	public void deleteAddress(Long id) { addressRepository.deleteById(id); }
	
	@Override
	public void finalize() throws IOException {
		mapper.closeStreams();
	}
}
