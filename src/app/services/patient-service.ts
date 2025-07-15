import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

  export interface PatientInfo {
  id?: number;
  name: string;
  age: number | null;
  gender: string;
  contact: string;
}

@Injectable({
  providedIn: 'root'
})
export class PatientService {
  private apiUrl = 'http://localhost:8080/api/patients';

  constructor(private http: HttpClient) {}
   
  

  getPatients(): Observable<PatientInfo[]> {
    return this.http.get<PatientInfo[]>(this.apiUrl);
  }
    
  addPatient(patient: PatientInfo): Observable<PatientInfo> {
    return this.http.post<PatientInfo>(this.apiUrl, patient);
  }

  updatePatient(id: number, patient: PatientInfo): Observable<PatientInfo> {
    return this.http.put<PatientInfo>(`${this.apiUrl}/${id}`, patient);
  }

  deletePatient(id: number): Observable<void> {
  return this.http.delete<void>(`http://localhost:8080/api/patients/${id}`);
  }
}
