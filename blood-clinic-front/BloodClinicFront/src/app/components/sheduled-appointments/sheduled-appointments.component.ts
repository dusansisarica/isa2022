import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CenterService } from 'src/app/services/center.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-sheduled-appointments',
  templateUrl: './sheduled-appointments.component.html',
  styleUrls: ['./sheduled-appointments.component.css']
})
export class SheduledAppointmentsComponent implements OnInit {

  public appointments: any;
  constructor(private router: Router, private centerService: CenterService) { }

  ngOnInit(): void {
    this.centerService.getScheduledAppointments().subscribe(data => {
      this.appointments = data;
    })
  }

  public cancelAppointment(id: any){
    this.centerService.cancelAppointment(id).subscribe(data => {
      this.appointments = data;
      window.location.reload();
    }, error => {
      Swal.fire({icon: 'error',
      title: 'Oops...',
      text: 'This appointment cant be canceled!'}).then()
    })
  }

}
