import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { AllCentersComponent } from './components/all-centers/all-centers.component';
import { OneCenterComponent } from './components/one-center/one-center.component';
import { SheduledAppointmentsComponent } from './components/sheduled-appointments/sheduled-appointments.component';
import { FinishedAppointmentsComponent } from './components/finished-appointments/finished-appointments.component';
import { AllComplaintsCenterComponent } from './components/all-complaints/all-complaints.component';
import { AllComplaintsEmployeeComponent } from './components/all-complaints-employee/all-complaints-employee.component';
import { AnswersComponent } from './components/answers/answers.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'login'},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegistrationComponent},
  {path: 'homepage', component: HomepageComponent, children: [
    {path: 'centers', component: AllCentersComponent},
    {path: 'centers/:id', component: OneCenterComponent},
    {path: 'appointments/scheduled', component: SheduledAppointmentsComponent},
    {path: 'appointments/finished', component: FinishedAppointmentsComponent},
    {path: 'complaints/center', component: AllComplaintsCenterComponent},
    {path: 'complaints/employee', component: AllComplaintsEmployeeComponent},
    {path: 'complaints/answers', component: AnswersComponent}
  ]},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
