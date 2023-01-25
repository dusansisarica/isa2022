import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CenterService } from 'src/app/services/center.service';
import { ComplaintService } from 'src/app/services/complaint.service';

@Component({
  selector: 'app-all-complaints',
  templateUrl: './all-complaints.component.html',
  styleUrls: ['./all-complaints.component.css']
})
export class AllComplaintsCenterComponent implements OnInit {

  public complaints : any;
  public center : any;
  public complaintId : any;
  public str : any;
  constructor(private router: Router, private complaintsService : ComplaintService, private centerService : CenterService) { }

  ngOnInit(): void {
    this.complaintsService.getAllComplaintsCenter().subscribe(data => {
      this.complaints = data;
    })
  }

  public findCenterName(id : any) : any{
    console.log(this.centerService.getCenterById(id).subscribe());
  }

  public show(id : any){
    return id == this.complaintId;
  }

  public setId(id : any){
    this.complaintId = id;
  }

  public sendAnswer(email : any, id : any){
    const body = {
      answer : this.str,
      email : email,
      center : id
    }
    this.complaintsService.answer(body).subscribe();
  }

}
