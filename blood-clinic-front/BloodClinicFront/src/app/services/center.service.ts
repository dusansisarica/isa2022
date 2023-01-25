import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CenterService {

  private baseUrl = environment.baseUrl;
  constructor(private http: HttpClient) { }

  public getAllCenters(): Observable<any> {
    return this.http.get(this.baseUrl + 'api/centers');
  }

  public getAllCentersSort(string : any): Observable<any> {
    return this.http.get(this.baseUrl + 'api/centers' + string);
  }

  public getCenterById(id : any): Observable<any> {
    return this.http.get(this.baseUrl + `api/centers/${id}`);
  }

  public scheduleAppointment(id : any): Observable<any> {
    return this.http.get(this.baseUrl + `api/appointments/schedule/${id}`);
  }

  public getScheduledAppointments(): Observable<any> {
    return this.http.get(this.baseUrl + `api/appointments/scheduled`);
  }

  public cancelAppointment(id : any): Observable<any> {
    return this.http.get(this.baseUrl + `api/appointments/cancel/${id}`);
  }

  public getFinishedAppointments(): Observable<any> {
    return this.http.get(this.baseUrl + `api/appointments/finished`);
  }

  public getFinishedAppointmentsSort(string : any): Observable<any>{
    return this.http.get(this.baseUrl + 'api/appointments/finished' + string);
  }

  public sendComplaint(body : any): Observable<any>{
    return this.http.post(this.baseUrl + 'api/centers/complaint', body);
  }

  public sendComplaintEmployee(body : any): Observable<any>{
    return this.http.post(this.baseUrl + 'api/employee/complaint', body);
  }
}
