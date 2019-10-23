package com.collabera.finalProject.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.finalProject.model.Address;
import com.collabera.finalProject.service.AddressService;


@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping(path = "/addaddress")
	public @ResponseBody String addNewAddress (@RequestBody @Valid Address aAddress)
	{
		addressService.addAddress(
				aAddress.getStreetNumber(),
				aAddress.getStreetName(),
				aAddress.getSuiteNo(),
				aAddress.getTownship(),
				aAddress.getState(),
				aAddress.getZip(),
				aAddress.getCountry()
				);
		
		return "Saved";
	}
	
	@GetMapping(path = "/alladdresses")
	public @ResponseBody Iterable<Address> getAllAddresss()
	{
		return addressService.findAll();
	}
	
	@GetMapping(path = "/getaddress/{id}")
	public Optional<Address> getAddressById(@PathVariable Long id)
	{
		return addressService.getAddressById(id);
	}
	
	@PutMapping("/updateaddress")
	public String updateAddress(@RequestBody @Valid Address address)
	{
		System.out.println("Added Address");
		addressService.updateAddress(address);
		return "Updated";
	}
	
	@DeleteMapping("/deleteaddress/{id}")
	public void deleteAddress(@PathVariable String id)
	{
		addressService.deleteAddress(Long.parseLong(id));
	}
}
