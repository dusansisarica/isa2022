import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ComplaintService {

  private baseUrl = environment.baseUrl;
  constructor(private http: HttpClient) { }

  public getAllComplaintsCenter(): Observable<any> {
    return this.http.get(this.baseUrl + 'api/complaints/center');
  }

  public getAllComplaintsEmployee(): Observable<any> {
    return this.http.get(this.baseUrl + 'api/complaints/employee');
  }

  public answer(body : any): Observable<any> {
    return this.http.post(this.baseUrl + `api/complaints/answer`, body);
  }

  public getAnswers(): Observable<any> {
    return this.http.get(this.baseUrl + `api/complaints/answered`);
  }
}
