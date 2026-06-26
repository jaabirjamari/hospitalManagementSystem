package com.example.hospitalSystem.repository;

import com.example.hospitalSystem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
    
}
