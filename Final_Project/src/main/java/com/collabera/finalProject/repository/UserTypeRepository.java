package com.collabera.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.finalProject.model.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {

}
