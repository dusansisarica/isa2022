import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CenterService } from 'src/app/services/center.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-one-center',
  templateUrl: './one-center.component.html',
  styleUrls: ['./one-center.component.css']
})
export class OneCenterComponent implements OnInit {

  public center: any;
  public appointments: any;

  constructor(private router: Router, private route: ActivatedRoute, private centerService: CenterService) { }

  ngOnInit(): void {
    this.setUpCenter(this.route.snapshot.params.id);
  }

  setUpCenter(id : any){
    console.log(id);
    this.centerService.getCenterById(id).subscribe(data => {
      this.center = data.center;
      this.appointments = data.appointments;
      console.log(data);
      console.log(this.center);
    })
  
  }

  public scheduleAppointment(id : any){
    this.centerService.scheduleAppointment(id).subscribe(data => {
      console.log(data);
      Swal.fire('Sucess!', 'success').then((result) => {this.router.navigate(['homepage/centers']);});
      window.location.reload();
    }, error => { 
      Swal.fire({icon: 'error',
      title: 'Oops...',
      text: 'Something went wrong!'}).then()   
    });
  }

}
