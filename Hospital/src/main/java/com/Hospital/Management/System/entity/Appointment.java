package com.Hospital.Management.System.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
public class Appointment {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String patientName;
	    private String doctorName;
	    private LocalDate date;
	    private LocalTime time;
	    public int getId() { return id; }
	    public void setId(int id) { this.id = id; }

	    public String getPatientName() { return patientName; }
	    public void setPatientName(String patientName) { this.patientName = patientName; }

	    public String getDoctorName() { return doctorName; }
	    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

	    public LocalDate getDate() { return date; }
	    public void setDate(LocalDate date) { this.date = date; }

	    public LocalTime getTime() { return time; }
	    public void setTime(LocalTime time) { this.time = time; }
	}


