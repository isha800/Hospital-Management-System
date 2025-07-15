import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ProfileService } from '../../services/profile.service';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-my-profile',
  imports: [FormsModule,CommonModule],
  templateUrl: './my-profile.html',
  styleUrl: './my-profile.css'
})
export class MyProfile implements OnInit {
  user: any = {};                  
editMode: boolean = false;       
email: string = 'priyad77888@gmail.com'; 

constructor(private profileService: ProfileService) {}

ngOnInit(): void {
  this.loadUserProfile();
}

loadUserProfile(): void {
  this.profileService.getProfile(this.email).subscribe({
    next: (data) => {
      this.user = data;
    },
    error: (err) => {
      console.error('Failed to load user profile', err);
    }
  });
}

enableEdit(): void {
  this.editMode = true;
}

cancelEdit(): void {
  this.editMode = false;
  this.loadUserProfile();
}

saveProfile(): void {
  const updatedData = {
    ...this.user,
    email: this.email 
  };

  this.profileService.updateProfile(updatedData).subscribe({
    next: (data) => {
      this.user = data;
      this.editMode = false;
    },
    error: (err) => {
      console.error('Profile update failed', err);
    }
  });
}
}