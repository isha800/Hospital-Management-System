package com.Hospital.Management.System.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.Management.System.entity.Appointment;
import com.Hospital.Management.System.repository.AppointmentRepository;
import com.Hospital.Management.System.repository.DoctorRepository;
import com.Hospital.Management.System.repository.PatientRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

	 @Autowired private DoctorRepository doctorRepo;
	   @Autowired private PatientRepository patientRepo;
	   @Autowired private AppointmentRepository appointmentRepo;

    @GetMapping("/doctors/count")
    public long getDoctorCount() {
        return doctorRepo.count();
    }

    @GetMapping("/patients/count")
    public long getPatientCount() {
        return patientRepo.count();
    }

    @GetMapping("/appointments/count")
    public long getAppointmentCount() {
        return appointmentRepo.count();
    }

    @GetMapping("/upcoming")
    public List<Appointment> getUpcomingAppointments() {
        LocalDate today = LocalDate.now();
        return appointmentRepo.findByDateAfterOrderByDateAsc(today);
    }
    }
    

