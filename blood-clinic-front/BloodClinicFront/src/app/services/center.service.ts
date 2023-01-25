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

  public getCenterById(id : any): Observable<any> {
    return this.http.get(this.baseUrl + `api/centers/${id}`);
  }

  public scheduleAppointment(id : any): Observable<any> {
    return this.http.get(this.baseUrl + `api/appointments/schedule/${id}`);
  }
}
