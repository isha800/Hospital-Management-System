import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {
  url="http://localhost:8080/api/dashboard/";
  constructor(private http:HttpClient) { }
  getDoctorCount(){return this.http.get<number>(this.url+'doctors/count'); }
  getPatientCount(){return this.http.get<number>(this.url+'patients/count'); }
  getAppointmentCount(){return this.http.get<number>(this.url+'appointments/count'); }
  getUpcomingAppointments(){return this.http.get<any[]>(this.url+'upcoming'); }
}
