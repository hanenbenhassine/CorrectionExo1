package com.example.CorrectionExo1.repository;

import com.example.CorrectionExo1.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor,Integer> {
}
