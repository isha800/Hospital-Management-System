import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { Login } from "./components/login/login";
import { Dashboard } from './components/dashboard/dashboard';
import { Doctor } from './components/doctor/doctor';
import { Patient } from './components/patient/patient';
import { Appointment } from './components/appointment/appointment';
import { MyProfile } from './components/my-profile/my-profile';
import { ForgotPasswordComponent } from './components/forgot-password.component/forgot-password.component';
@Component({
  selector: 'app-root',
  standalone:true,
  imports: [FormsModule, Login, Dashboard, Patient,Appointment,Doctor,RouterOutlet,RouterLink,MyProfile,ForgotPasswordComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'hospital-management';
}
