package com.example.hospitalSystem.controller;

import com.example.hospitalSystem.model.Patient;
import com.example.hospitalSystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController // means this clsas hands incoming web request. automaticallt convert whatever java obj into json
@RequestMapping("/api/patients") //url 
public class PatientController {

    // autowire: since paitentReposistory is a interface inject it, turn it into a obj 
    @Autowired
    private PatientRepository pRepository;

    // GET /api/patients/{id} -> fetch one patient by their id
    // @PathVariable grabs the id value from the URL itself
    @GetMapping("/{id}")
    public Patient getPaitentById(@PathVariable Long id){
        return pRepository.findById(id).orElse(null);
    }

    // POST /api/patients/ -> adds patient
    @PostMapping
    public Patient addPatient(@RequestBody Patient patient){
        Patient savedPatient = pRepository.save(patient);
        return savedPatient;
    }


    // PUT = UPDATE /api/patient/{id} -> updates patient info
    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient updatePatient){
        Patient existing_Patients = pRepository.findById(id).orElse(null);

            if (existing_Patients != null){
                existing_Patients.setName(updatePatient.getName());
                existing_Patients.setDob(updatePatient.getDob());
                existing_Patients.setGender(updatePatient.getGender());
                existing_Patients.setAddress(updatePatient.getAddress());
                existing_Patients.setPhoneNumber(updatePatient.getPhoneNumber());

                return pRepository.save(existing_Patients);
                
            }
        return null;
    }

    // deleting 
    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id){
        Patient existingPatient = pRepository.findById(id).orElse(null);
        
        if(existingPatient != null){
            pRepository.deleteById(id);
            return "Patient deleted successfully";
        }

        return "Patient not Found"; 

    }

}
