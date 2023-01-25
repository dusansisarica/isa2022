import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CenterService } from 'src/app/services/center.service';

@Component({
  selector: 'app-all-centers',
  templateUrl: './all-centers.component.html',
  styleUrls: ['./all-centers.component.css']
})
export class AllCentersComponent implements OnInit {

  public centers : any;
  constructor(private router: Router, private centerService: CenterService) { }

  ngOnInit(): void {
    this.getAllCenters();
  }

  private getAllCenters(): void {
    this.centerService.getAllCenters().subscribe(data => {
      this.centers = data;

    }, error => {
      alert("Error");
    })
  }

  public showCenter(id : any): void {
    console.log(id);
    this.router.navigateByUrl(`homepage/centers/${id}`);
  }

  public sortBy(event : any){
    this.centerService.getAllCentersSort("?sort_by=" + event).subscribe(data => {
      this.centers = data;

    }, error => {
      alert("Error");
    })
  }

  public resetSort(): void {
    this.getAllCenters();
  }

}
