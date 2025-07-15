import { Component, OnInit } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { DashboardService } from '../../services/dashboard-service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-dashboard',
  standalone: true,           
  imports: [RouterLink,RouterOutlet,CommonModule, FormsModule],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css'
})
export class Dashboard implements OnInit  {
  
  doctorCount:number=0;
  PatientCount:number=0;
  appointmentCount:number=0;
  appointments:any[]=[];
  
  constructor(private service: DashboardService,private router: Router){}
  logout(): void {
   
     const confirmLogout = confirm('Are you sure you want to logout?');
  if (confirmLogout) {
    localStorage.removeItem('authToken');
    localStorage.removeItem('user');
    this.router.navigate(['/login']);
    }
  }
  
  ngOnInit(): void {
    this.service.getDoctorCount().subscribe((res:any)=>{this.doctorCount=res});
    this.service.getPatientCount().subscribe((res:any) =>{ this.PatientCount=res});
    this.service.getAppointmentCount().subscribe((res:any) => {this.appointmentCount=res});
    this.service.getUpcomingAppointments().subscribe((res:any) =>{ this. appointments=res});
    
  }

}
