package com.example.hospitalSystem.service;

import com.example.hospitalSystem.model.Patient;
import com.example.hospitalSystem.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> updatePatient(Long id, Patient updated) {
        return patientRepository.findById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setDob(updated.getDob());
            existing.setGender(updated.getGender());
            existing.setAddress(updated.getAddress());
            existing.setPhoneNumber(updated.getPhoneNumber());
            return patientRepository.save(existing);
        });
    }

    public boolean deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            return false;
        }
        patientRepository.deleteById(id);
        return true;
    }
}