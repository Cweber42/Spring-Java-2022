package com.rpsar.SpringCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rpsar.SpringCrud.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
