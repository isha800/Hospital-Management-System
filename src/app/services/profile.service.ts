import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  
  private apiUrl = 'http://localhost:8080/api/user';

  constructor(private http: HttpClient) {}

  getProfile(email: string): Observable<any> {
  return this.http.get(`${this.apiUrl}/me?email=${email}`);}

  
  updateProfile(profileData: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/update`, profileData); }

 
}

