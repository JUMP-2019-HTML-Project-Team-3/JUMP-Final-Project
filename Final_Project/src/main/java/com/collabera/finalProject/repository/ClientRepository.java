package com.collabera.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.finalProject.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
