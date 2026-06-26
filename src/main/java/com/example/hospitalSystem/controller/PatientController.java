package com.example.hospitalSystem.controller;

import com.example.hospitalSystem.model.Patient;
import com.example.hospitalSystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController // means this clsas hands incoming web request. automaticallt convert whatever java obj into json
@RequestMapping("/api/patients") //url 
public class PatientController {

    // autowire: since paitentReposistory is a interface inject it, turn it into a obj 
    @Autowired
    private PatientRepository patientRepository;

    // GET /api/patients/{id} -> fetch one patient by their id
    // @PathVariable grabs the id value from the URL itself
    @GetMapping("/{id}")
    public Patient getPaitentById(@PathVariable Long id){
        return patientRepository.findById(id).orElse(null);
    }

    // posting 
    @PostMapping
    public Paitent 


    // updating 

    @PutMapping

    // deleting 


    @DeleteMapping

















    
}
