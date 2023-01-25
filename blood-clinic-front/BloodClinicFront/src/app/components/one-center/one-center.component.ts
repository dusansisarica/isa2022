import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CenterService } from 'src/app/services/center.service';

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
      window.location.reload();
    });
  }

}
