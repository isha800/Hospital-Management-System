package com.Hospital.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hospital.Management.System.entity.MedDoctor;

public interface DoctorRepository extends JpaRepository<MedDoctor, Long> {
}

