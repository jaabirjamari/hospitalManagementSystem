package com.example.hospitalSystem.service;

import com.example.hospitalSystem.model.Doctor;
import com.example.hospitalSystem.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Optional<Doctor> updateDoctor(Long id, Doctor updated) {
        return doctorRepository.findById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setSpecialization(updated.getSpecialization());
            existing.setPhoneNumber(updated.getPhoneNumber());
            return doctorRepository.save(existing);
        });
    }

    public boolean deleteDoctor(Long id) {
        if (!doctorRepository.existsById(id)) {
            return false;
        }
        doctorRepository.deleteById(id);
        return true;
    }
}