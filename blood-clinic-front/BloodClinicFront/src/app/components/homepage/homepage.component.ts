import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  public showCenters(){
    this.router.navigateByUrl(`homepage/centers`);
  }

  public logout(){
    localStorage.removeItem("jwt");
    this.router.navigateByUrl(`login`);
  }

  public showScheduledAppointments(){
    this.router.navigateByUrl(`homepage/appointments/scheduled`);
  }

  public showFinishedAppointments(){
    this.router.navigateByUrl(`homepage/appointments/finished`);
  }

  public isUser(){
    return localStorage.getItem("role") == "ROLE_USER";
  }

  public isAdmin(){
    return localStorage.getItem("role") == "ROLE_ADMIN";
  }

  public showCenterComplaints(){
    this.router.navigateByUrl(`homepage/complaints/center`);
  }

  public showEmployeeComplaints(){
    this.router.navigateByUrl(`homepage/complaints/employee`);
  }

  public showAnsweredComplaints(){
    this.router.navigateByUrl(`homepage/complaints/answers`);
  }

  public survey(){
    this.router.navigateByUrl(`homepage/survey`);
  }

}
