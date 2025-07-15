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

import com.Hospital.Management.System.entity.MedDoctor;
import com.Hospital.Management.System.repository.DoctorRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
	 @Autowired
	    private DoctorRepository doctorRepository;

	    @GetMapping("/names")
	    public List<String> getDoctorNames() {
	        return doctorRepository.findAll()
	                .stream()
	                .map(MedDoctor::getName)
	                .collect(Collectors.toList());
	    }

	@Autowired
    private DoctorRepository doctorRepo;

    @GetMapping
    public List<MedDoctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    @PostMapping
    public MedDoctor addDoctor(@RequestBody MedDoctor doctor) {
        return doctorRepo.save(doctor);
    }

    @PutMapping("/{id}")
    public MedDoctor updateDoctor(@PathVariable Long id, @RequestBody MedDoctor doctor) {
        doctor.setId(id);
        return doctorRepo.save(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorRepo.deleteById(id);
    }
}

