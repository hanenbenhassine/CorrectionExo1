package com.example.CorrectionExo1.repository;

import com.example.CorrectionExo1.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
