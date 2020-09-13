import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
// @ts-ignore
import { Visit } from './visit';
import {environment} from '../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class VisitService {

  constructor(private http: HttpClient) {
  }

  // Do wszystkich wizyt
  getVisits(): Observable<RootObject> {
    return this.http.get<RootObject>(environment.apiUrl + 'api/visits');
  }

  // Do jednej konkretnej
  getVisit(visitId): Observable<Visit> {
    return this.http.get<Visit>('http://localhost:8080/api/visit/' + visitId);
  }

  addVisit(visitObject): any {
    // tslint:disable-next-line:ban-types
    return this.http.post<Object>((environment.apiUrl + 'api/visit/start_visit'), visitObject);
  }
}

export interface ClientIdentificator {
  isInUse: boolean;
}

export interface AquaparkAttractionUsage {
  timeSpendInMinutes: number;
  enteringTime: string;
  leavingTime: string;
}

export interface Client {
  ownsAccount: boolean;
  visitsId: number[];
}

export interface Embedded2 {
  clientIdentificator: ClientIdentificator;
  aquaparkAttractionUsages: AquaparkAttractionUsage[];
  client: Client;
}

export interface Self {
  href: string;
}

export interface Visit2 {
  href: string;
}

export interface ClientIdentificator2 {
  href: string;
}

export interface AquaparkAttractionUsages {
  href: string;
}

export interface Client2 {
  href: string;
}

export interface Links {
  self: Self;
  visit: Visit2;
  clientIdentificator: ClientIdentificator2;
  aquaparkAttractionUsages: AquaparkAttractionUsages;
  client: Client2;
}

export interface Visit {
  [key: string]: any;
  clientName?: string;
  date: string;
  startTime: string;
  endTime: string;
  value: number;
  identificatorId: number;
  hasEnded: boolean;
  _embedded: Embedded2;
  _links: Links;
}

export interface Embedded {
  visits: Visit[];
}

export interface Self2 {
  href: string;
  templated: boolean;
}

export interface Profile {
  href: string;
}

export interface Search {
  href: string;
}

export interface Links2 {
  self: Self2;
  profile: Profile;
  search: Search;
}

export interface Page {
  size: number;
  totalElements: number;
  totalPages: number;
  number: number;
}

export interface RootObject {
  _embedded: Embedded;
  _links: Links2;
  page: Page;
}

