import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Visit } from './visit';


@Injectable({
  providedIn: 'root'
})

export class VisitService {

  constructor(private http: HttpClient) { }
  // Do wszystkich wizyt
  getVisits(): Observable<Visit[]> {
    return this.http.get<Visit[]>('http://localhost:8080/api/visit/');
  }

  // Do jednej konkretnej
  getVisit(visitId): Observable<Visit> {
    return this.http.get<Visit>('http://localhost:8080/api/visits/' + visitId);
  }
}
