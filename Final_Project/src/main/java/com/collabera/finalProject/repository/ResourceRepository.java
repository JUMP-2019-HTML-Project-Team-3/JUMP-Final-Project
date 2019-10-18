package com.collabera.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.finalProject.model.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

}
