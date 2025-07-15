import { Component, OnInit } from '@angular/core';
import { Appoint,  AppointmentService} from '../../services/appointment-services';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-appointment',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './appointment.html',
  styleUrl: './appointment.css'
})
export class Appointment implements OnInit {
 appointments: Appoint[] = [];
  selectedPatient = '';
  selectedDoctor = '';
  selectedDate = '';
  selectedTime = '';
  editingAppointment: Appoint | null = null;
  patients: string[] = [];
  doctors: string[] = [];

  constructor(private appointmentService: AppointmentService) {}

  ngOnInit(): void {
    this.getAllAppointments();
    this.loadDropdownData();
  }

  getAllAppointments() {
    this.appointmentService.getAppointments().subscribe(data => {
    this.appointments = data;
    });
  }

  bookAppointment() {
      const appointment: Appoint = {
      patientName: this.selectedPatient,
      doctorName: this.selectedDoctor,
      date: this.selectedDate,
      time: this.selectedTime
    };

    if (this.editingAppointment?.id) {
      this.appointmentService.updateAppointment(this.editingAppointment.id, appointment).subscribe(() => {
        this.getAllAppointments();
        this.clearForm();
      });
    } else {
      this.appointmentService.addAppointment(appointment).subscribe(() => {
        this.getAllAppointments();
        this.clearForm();
      });
    }
  }

  editAppointment(app: Appoint) {
    this.selectedPatient = app.patientName;
    this.selectedDoctor = app.doctorName;
    this.selectedDate = app.date;
    this.selectedTime = app.time;
    this.editingAppointment = app;
  }

  deleteAppointment(app: Appoint) {
    if (app.id) {
      this.appointmentService.deleteAppointment(app.id).subscribe(() => {
        alert('appointment deleted successfully.');
        this.getAllAppointments();
      });
    }
  }

  clearForm() {
    this.selectedPatient = '';
    this.selectedPatient = '';
    this.selectedDate = '';
    this.selectedTime = '';
    this.editingAppointment = null;
  }
  loadDropdownData() {
  this.appointmentService.getAllPatients().subscribe((data:any) => {this.patients = data});
  this.appointmentService.getAllDoctors().subscribe((data :any)=> {this.doctors = data});
}
}
