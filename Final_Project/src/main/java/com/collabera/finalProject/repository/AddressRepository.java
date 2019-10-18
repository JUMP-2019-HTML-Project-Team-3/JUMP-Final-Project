package com.collabera.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.finalProject.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
