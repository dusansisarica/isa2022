import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CenterService } from 'src/app/services/center.service';

@Component({
  selector: 'app-finished-appointments',
  templateUrl: './finished-appointments.component.html',
  styleUrls: ['./finished-appointments.component.css']
})
export class FinishedAppointmentsComponent implements OnInit {

  public appointments: any;
  public center : any;
  public employee : any;
  public str : any;
  constructor(private router: Router, private centerService: CenterService) { }

  ngOnInit(): void {
    this.centerService.getFinishedAppointments().subscribe(data => {
      this.appointments = data;
    })
  }

  public sortBy(event : any){
    this.centerService.getFinishedAppointmentsSort("?sort_by="+event).subscribe(data => {
      this.appointments = data;
    })
  }

  public resetSort(): void {
    this.center = null;
    this.employee = null
    this.centerService.getFinishedAppointments().subscribe(data => {
      this.appointments = data;
    })
  }

  public setCenter(id : any): void{
    this.str = null;
    this.center = id;
    this.employee = null
  }

  public setEmployee(id : any): void{
    this.str = null;
    this.center = null;
    this.employee = id;
  }

  public showCenter(id : any): boolean {
      return id == this.center;
  }
  public showEmployee(id : any): boolean {
    return id == this.employee;
}

  public sendComplaintForCenter(id : any){
    console.log(id + " " + this.str);
    const body = {
      center_id : id,
      text : this.str
    }
    this.center = null;
    this.centerService.sendComplaint(body).subscribe();
  }

  public sendComplaintForEmployee(id : any){
    console.log(id + " " + this.str);
    const body = {
      centerAdministrator : id,
      text : this.str
    }
    this.employee = null;
    this.centerService.sendComplaintEmployee(body).subscribe();
  }
}
