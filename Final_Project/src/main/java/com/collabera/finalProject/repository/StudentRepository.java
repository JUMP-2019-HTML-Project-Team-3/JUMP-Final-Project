package com.collabera.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.finalProject.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
