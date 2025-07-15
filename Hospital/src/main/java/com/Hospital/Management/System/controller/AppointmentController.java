package com.Hospital.Management.System.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Hospital.Management.System.entity.Appointment;
import com.Hospital.Management.System.repository.AppointmentRepository;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {
	 @Autowired
	    private AppointmentRepository repository;

	    @GetMapping
	    public List<Appointment> getAllAppointments() {
	        return repository.findAll();
	    }

	    @PostMapping
	    public Appointment createAppointment(@RequestBody Appointment appointment) {
	        return repository.save(appointment);
	    }

	    @PutMapping("/{id}")
	    public Appointment updateAppointment(@PathVariable int id, @RequestBody Appointment updatedAppointment) {
	        Appointment app = repository.findById(id).orElse(null);
	        if (app != null) {
	            app.setPatientName(updatedAppointment.getPatientName());
	            app.setDoctorName(updatedAppointment.getDoctorName());
	            app.setDate(updatedAppointment.getDate());
	            app.setTime(updatedAppointment.getTime());
	            return repository.save(app);
	        }
	        return null;
	    }

	    @DeleteMapping("/{id}")
	    public void deleteAppointment(@PathVariable int id) {
	        repository.deleteById(id);
	    }
	}


