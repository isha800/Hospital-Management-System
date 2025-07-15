import { Component,  OnInit } from '@angular/core';
import { DoctorService, doc} from '../../services/doctor-service';
import { CommonModule, NgFor } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-doctor',
  standalone: true,           
  imports: [CommonModule, FormsModule,NgFor],  
  templateUrl: './doctor.html',
  styleUrl: './doctor.css'
})
export class Doctor implements OnInit {
  doctors: doc[] = [];
  newDoctor: doc = { name: '', specialization: '', contact: '' };
  isEditing: boolean = false;
  editingId: number | null = null;
 doctor: any;
 

  
  constructor(private doctorService: DoctorService) { }
   ngOnInit(): void {
    this.getAllDoctors();
  }

  getAllDoctors(): void {
    this.doctorService.getDoctors().subscribe((data) => {
      this.doctors = data;
    });
  }

  addDoctor(): void {
    if (!this.newDoctor.name || !this.newDoctor.specialization || !this.newDoctor.contact) {
      alert('Please fill all fields');
      return;
    }

    this.doctorService.addDoctor(this.newDoctor).subscribe(() => {
      this.getAllDoctors();
      this.newDoctor = { name: '', specialization: '', contact: '' };
    });
  }

  editDoctor(doctor: doc): void {
    this.newDoctor = { ...doctor };
    this.isEditing = true;
    this.editingId = doctor.id || null;
  }

  updateDoctor(): void {
    if (this.editingId !== null) {
      this.doctorService.updateDoctor(this.editingId, this.newDoctor).subscribe(() => {
        this.getAllDoctors();
        this.cancelEdit();
      });
    }
  }


  deleteDoctor(doctor: doc): void {
  if (!doctor.id) {
    alert('Doctor ID missing!');
    return;
  }

  if (confirm('Are you sure you want to delete this doctor?')) {
    this.doctorService.deleteDoctor(doctor.id).subscribe(() => {
      this.getAllDoctors();
    });
  }
}

  cancelEdit(): void {
    this.newDoctor = { name: '', specialization: '', contact: '' };
    this.isEditing = false;
    this.editingId = null;
  }
}


  




