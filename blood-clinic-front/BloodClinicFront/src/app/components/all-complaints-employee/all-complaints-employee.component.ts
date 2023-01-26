import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ComplaintService } from 'src/app/services/complaint.service';

@Component({
  selector: 'app-all-complaints-employee',
  templateUrl: './all-complaints-employee.component.html',
  styleUrls: ['./all-complaints-employee.component.css']
})
export class AllComplaintsEmployeeComponent implements OnInit {

  public complaints : any;
  public center : any;
  public complaintId : any;
  public str : any;
  constructor(private router: Router, private complaintsService : ComplaintService) { }

  ngOnInit(): void {
    this.complaintsService.getAllComplaintsEmployee().subscribe(data => {
      this.complaints = data;
    })
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
      employee : id
    }
    console.log(id);
    this.complaintsService.answer(body).subscribe();
    window.location.reload();
  }
}
