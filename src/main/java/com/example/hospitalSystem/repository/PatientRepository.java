package com.example.hospitalSystem.repository;

import com.example.hospitalSystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    
}
