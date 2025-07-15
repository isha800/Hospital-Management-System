import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
export interface doc {
  id?: number;
  name: string;
  specialization: string;
  contact: string;
}

@Injectable({
  providedIn: 'root'
})
export class DoctorService {
  private baseUrl = 'http://localhost:8080/api/doctors'; 

  constructor(private http: HttpClient) {}

  getDoctors(): Observable<doc[]> {
    return this.http.get<doc[]>(this.baseUrl);
  }

  addDoctor(doctor: doc): Observable<doc> {
    return this.http.post<doc>(this.baseUrl, doctor);
  }

  updateDoctor(id: number, doctor: doc): Observable<doc> {
    return this.http.put<doc>(`${this.baseUrl}/${id}`, doctor);
  }

  deleteDoctor(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}

