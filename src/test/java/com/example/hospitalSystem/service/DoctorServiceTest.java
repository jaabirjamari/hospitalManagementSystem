package com.example.hospitalSystem.service;

import com.example.hospitalSystem.model.Doctor;
import com.example.hospitalSystem.repository.DoctorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorService doctorService;

    @Test
    void getDoctorById_returnsDoctor_whenFound() {
        Doctor doctor = new Doctor("Dr. Lee", "Cardiology", "6515550199");
        when(doctorRepository.findById(1L)).thenReturn(Optional.of(doctor));

        Optional<Doctor> result = doctorService.getDoctorById(1L);

        assertTrue(result.isPresent());
        assertEquals("Dr. Lee", result.get().getName());
    }

    @Test
    void getDoctorById_returnsEmpty_whenNotFound() {
        when(doctorRepository.findById(99L)).thenReturn(Optional.empty());

        assertTrue(doctorService.getDoctorById(99L).isEmpty());
    }

    @Test
    void updateDoctor_updatesFields_whenFound() {
        Doctor existing = new Doctor("Dr. Lee", "Cardiology", "6515550199");
        Doctor updated = new Doctor("Dr. Lee", "Neurology", "6515550111");
        when(doctorRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(doctorRepository.save(any(Doctor.class))).thenAnswer(inv -> inv.getArgument(0));

        Optional<Doctor> result = doctorService.updateDoctor(1L, updated);

        assertTrue(result.isPresent());
        assertEquals("Neurology", result.get().getSpecialization());
        assertEquals("6515550111", result.get().getPhoneNumber());
    }

    @Test
    void deleteDoctor_returnsFalse_andDoesNotDelete_whenMissing() {
        when(doctorRepository.existsById(99L)).thenReturn(false);

        assertFalse(doctorService.deleteDoctor(99L));
        verify(doctorRepository, never()).deleteById(99L);
    }
}