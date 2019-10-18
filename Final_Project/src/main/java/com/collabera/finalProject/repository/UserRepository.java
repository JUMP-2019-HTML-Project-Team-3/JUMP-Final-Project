package com.collabera.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.finalProject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
