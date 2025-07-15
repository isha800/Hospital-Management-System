package com.Hospital.Management.System.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.Management.System.entity.Patient;
import com.Hospital.Management.System.repository.PatientRepository;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {
	@Autowired
    private PatientRepository patientRepository;

	@GetMapping("/names")
	public List<String> getPatientNames() {
	    return patientRepository.findAll()
	            .stream()
	            .map(Patient::getName)
	            .collect(Collectors.toList());
	}

	 
	    @GetMapping
	    public List<Patient> getAllPatients() {
	        return patientRepository.findAll();
	    }

	    @PostMapping
	    public Patient createPatient(@RequestBody Patient patient) {
	        return patientRepository.save(patient);
	    }

	    @PutMapping("/{id}")
	    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
	        Patient patient = patientRepository.findById(id).orElseThrow();
	        patient.setName(patientDetails.getName());
	        patient.setAge(patientDetails.getAge());
	        patient.setGender(patientDetails.getGender());
	        patient.setContact(patientDetails.getContact());
	        return patientRepository.save(patient);
	    }

	    @DeleteMapping("/{id}")
	    public void deletePatient(@PathVariable Long id) {
	        patientRepository.deleteById(id);
	    }
	}	
