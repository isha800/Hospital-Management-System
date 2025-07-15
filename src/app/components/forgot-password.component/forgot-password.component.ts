import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-forgot-password.component',
  imports: [FormsModule,CommonModule],
  templateUrl: './forgot-password.component.html',
  styleUrl: './forgot-password.component.css'
})
export class ForgotPasswordComponent {
 email: string = '';

  constructor(private http: HttpClient) {}

  sendResetLink() {
    this.http.post('http://localhost:8080/api/auth/forgot-password', { email: this.email }).subscribe({
      next: () => {
        alert('Reset link sent (simulated)');
      },
      error: () => {
        alert('Email not found or server error');
      }
    });
  }
}