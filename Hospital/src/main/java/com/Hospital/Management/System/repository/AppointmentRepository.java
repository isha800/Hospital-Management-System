package com.Hospital.Management.System.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hospital.Management.System.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findByDateAfterOrderByDateAsc(LocalDate date);
}
