package com.Hospital.Management.System.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
	public class MedDoctor {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String specialization;
	    private String contact;

	    // Getters and Setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getSpecialization() { return specialization; }
	    public void setSpecialization(String specialization) { this.specialization = specialization; }

	    public String getContact() { return contact; }
	    public void setContact(String contact) { this.contact = contact; }
	}
	
