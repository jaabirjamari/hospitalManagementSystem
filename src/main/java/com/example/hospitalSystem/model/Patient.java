package com.example.hospitalSystem.model;

import java.time.LocalDate;
import jakarta.persistence.*;

    // connect to datebase
    @Entity
    // using in the urls
    @Table(name ="patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private LocalDate dob;
    private String gender;
    private String address;
    private String phoneNumber;

    // constructors
    public Patient(){}
    public Patient(String name, LocalDate dob, String gender, String address, String phoneNumber){
        this.name = name;
        this.dob = dob; 
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    // getters
    public long getId(){ return id; }
    public String getName(){ return name; }
    public LocalDate getDob(){ return dob;  }
    public String getGender(){ return gender; }
    public String getAddress(){ return address; }
    public String getPhoneNumber(){ return phoneNumber; }


    // setters
    public void setId(long id){ this.id = id; }
    public void setName(String name){ this.name = name; }
    public void setDob(LocalDate dob){ this.dob = dob; }
    public void setGender(String gender){ this.gender = gender; }
    public void setAddress(String address){ this.address = address; }
    public void setPhoneNumber(String phoneNumber){ this.phoneNumber = phoneNumber; }


}
