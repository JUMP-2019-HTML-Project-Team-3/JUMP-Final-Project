package com.collabera.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.finalProject.model.Tool;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {

}
