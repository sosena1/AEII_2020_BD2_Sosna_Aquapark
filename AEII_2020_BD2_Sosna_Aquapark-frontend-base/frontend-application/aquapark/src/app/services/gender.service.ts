import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Gender} from '../dao/gender';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GenderService {

  constructor(private http: HttpClient) { }
  private url = 'http://localhost:8080/api/aquapark/genders';

  getGenders(): Observable<Gender[]> {
    console.log('Getting genders');
    return this.http.get<Gender[]>(this.url);
  }
}
