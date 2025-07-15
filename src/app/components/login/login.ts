import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterLink],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
 showLogin = true;

  loginEmail = '';
  loginPassword = '';

  registerName = '';
  registerEmail = '';
  registerPassword = '';

  constructor(private http: HttpClient, private router: Router) {}

  login() {
    const credentials = {
      email: this.loginEmail,
      password: this.loginPassword
    };

    this.http.post('http://localhost:8080/api/auth/login', credentials).subscribe({
      next: (res: any) => {
        alert('Login successful');
        localStorage.setItem('authToken', res.token || 'dummyToken');
        localStorage.setItem('email', this.loginEmail);
        this.router.navigate(['/dashboard']);
      },
      error: (err) => {
        alert('Invalid login');
      }
    });
  }

  register() {
    const newUser = {
      name: this.registerName,
      email: this.registerEmail,
      password: this.registerPassword
    };

    this.http.post('http://localhost:8080/api/auth/register', newUser).subscribe({
      next: () => {
        alert('Registration successful. Please login!');
        this.showLogin = true;
      },
      error: (err) => {
      if (err.status === 409 || err.status === 400) {
        alert('This email is already registered.');
      } else {
        alert('Something went wrong. Try again.');
      }
    }
      });
  }
}