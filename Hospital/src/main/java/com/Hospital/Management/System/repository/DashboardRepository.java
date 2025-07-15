package com.Hospital.Management.System.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hospital.Management.System.entity.Appointment;
import com.Hospital.Management.System.entity.Patient;
import com.Hospital.Management.System.entity.doctor.Doctor;

public class DashboardRepository {

	public interface DoctorRepository extends JpaRepository<Doctor, Long> {}
	public interface PatientRepository extends JpaRepository<Patient, Long> {}
	public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
		List<Appointment> findByDateAfterOrderByDateAsc(LocalDate date);
	}
}

