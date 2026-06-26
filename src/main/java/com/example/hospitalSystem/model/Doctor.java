package com.example.hospitalSystem.model;

import jakarta.persistence.*;

// connect to database 
@Entity
// url 
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String specialization;
    private int phoneNumber;

    // constructor
    public Doctor(){}
    public Doctor(String name, String specialization, int phoneNumber){
        this.name = name; 
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
    }

    // getters
    public long getId(){ return id; }
    public String getName(){ return name; }
    public String getSpecialization(){ return specialization; }
    public int getPhoneNumber(){ return phoneNumber; }

    // setters
    public void setId(long id){ this.id = id; }
    public void setName(String name){ this.name = name; }
    public void setSpecialization(String specialization ){ this.specialization = specialization; }
    public void setPhoneNumber(int phoneNumber){ this.phoneNumber = phoneNumber; }
}
