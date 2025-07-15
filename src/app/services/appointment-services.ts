
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Appoint {
  id?: number;
  patientName: string;
  doctorName: string;
  date: string;
  time: string;
}

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  private baseUrl = 'http://localhost:8080/api/appointments';
  private doctorUrl = 'http://localhost:8080/api/doctors/names';
  private patientUrl = 'http://localhost:8080/api/patients/names';

  constructor(private http: HttpClient) {}

  getAppointments(): Observable<Appoint[]> {
    return this.http.get<Appoint[]>(this.baseUrl);
  }

  addAppointment(appointment: Appoint): Observable<Appoint> {
    return this.http.post<Appoint>(this.baseUrl, appointment);
  }

  updateAppointment(id: number, appointment: Appoint): Observable<Appoint> {
    return this.http.put<Appoint>(`${this.baseUrl}/${id}`, appointment);
  }

  deleteAppointment(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
   getAllDoctors(): Observable<string[]> {
    return this.http.get<string[]>(this.doctorUrl);
  }

  getAllPatients(): Observable<string[]> {
    return this.http.get<string[]>(this.patientUrl);
  }
}


