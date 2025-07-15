import { RouterModule, Routes } from '@angular/router';
import { Login } from './components/login/login';
import { Dashboard } from './components/dashboard/dashboard';
import { Doctor } from './components/doctor/doctor';
import { Patient } from './components/patient/patient';
import { NgModule } from '@angular/core';
import { Appointment } from './components/appointment/appointment';
import { MyProfile } from './components/my-profile/my-profile';
import { ForgotPasswordComponent } from './components/forgot-password.component/forgot-password.component';
import { AuthGuard } from './components/auth-guard';

export const routes: Routes = [
{path:'', redirectTo:'/login',pathMatch:'full'},
{ path:"login",component:Login},
{ path: 'forgot-password', component: ForgotPasswordComponent },
{ path:"dashboard",component:Dashboard, canActivate: [AuthGuard],
children:[
{ path:"doctor",component:Doctor},
{ path:"patient",component:Patient},
{ path:"appointment",component:Appointment}, 
{ path:"profile",component:MyProfile}  
] 
}  
];

