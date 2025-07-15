import { Component, OnInit } from '@angular/core';
import { PatientInfo, PatientService } from '../../services/patient-service';
import { FormsModule } from '@angular/forms';
import { CommonModule} from '@angular/common';

@Component({
  selector: 'app-patient',
  imports: [FormsModule,CommonModule],
  templateUrl: './patient.html',
  styleUrl: './patient.css'
})
export class Patient implements OnInit {
 
   patients: PatientInfo[] = [];
  newPatient: PatientInfo = { name: '', age:null as any , gender: '', contact: '' };
   isEditMode: boolean = false;
  editId: number | null = null;

  constructor(private patientService: PatientService) {}

  ngOnInit(): void {
    this.loadPatients();
  }

  loadPatients() {
    this.patientService.getPatients().subscribe(data => {
      this.patients = data;
    });
  }

  addOrUpdatePatient() {
    if (this.isEditMode && this.editId !== null) {
      this.patientService.updatePatient(this.editId, this.newPatient).subscribe(() => {
        this.resetForm();
        this.loadPatients();
      });
    } else {
      this.patientService.addPatient(this.newPatient).subscribe(() => {
        this.resetForm();
        this.loadPatients();
      });
    }
  }

  editPatient(patient: PatientInfo) {
    this.newPatient = { ...patient };
    this.isEditMode = true;
    this.editId = patient.id!;
  }

 deletePatient(patient: PatientInfo): void {
  if (!patient || !patient.id) {
    alert('Patient ID is missing!');
    return;
  }

  if (confirm(`Are you sure you want to delete patient "${patient.name}"?`)) {
    this.patientService.deletePatient(patient.id).subscribe(() => {
      alert('Patient deleted successfully.');
      this.loadPatients(); 
    });
  }
}

  resetForm() {
    this.newPatient = { name: '', age: null as any, gender: '', contact: '' };
    this.isEditMode = false;
    this.editId = null;
  }
  
}

