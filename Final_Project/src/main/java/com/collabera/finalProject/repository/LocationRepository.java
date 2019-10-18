package com.collabera.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.finalProject.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
