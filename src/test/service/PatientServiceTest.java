package com.example.hospitalSystem.service;

import com.example.hospitalSystem.model.Patient;
import com.example.hospitalSystem.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    @Test
    void getPatientById_returnsPatient_whenFound() {
        Patient patient = new Patient("Ava", LocalDate.of(1990, 5, 1), "F", "1 Main St", "6515550100");
        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));

        Optional<Patient> result = patientService.getPatientById(1L);

        assertTrue(result.isPresent());
        assertEquals("Ava", result.get().getName());
    }

    @Test
    void getPatientById_returnsEmpty_whenNotFound() {
        when(patientRepository.findById(99L)).thenReturn(Optional.empty());

        assertTrue(patientService.getPatientById(99L).isEmpty());
    }

    @Test
    void deletePatient_returnsFalse_andDoesNotDelete_whenMissing() {
        when(patientRepository.existsById(99L)).thenReturn(false);

        assertFalse(patientService.deletePatient(99L));
        verify(patientRepository, never()).deleteById(99L);
    }
}