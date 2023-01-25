import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ComplaintService } from 'src/app/services/complaint.service';

@Component({
  selector: 'app-answers',
  templateUrl: './answers.component.html',
  styleUrls: ['./answers.component.css']
})
export class AnswersComponent implements OnInit {
  public answers : any;

  constructor(private router : Router, private complaintsService : ComplaintService) { }

  ngOnInit(): void {
    this.complaintsService.getAnswers().subscribe(data => {
      this.answers = data;
    });
    console.log(this.answers)
  }

  public check(center : any){
    console.log(center);
    return center != null;
  }

}
