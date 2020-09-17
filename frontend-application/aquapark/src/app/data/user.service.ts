import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
// @ts-ignore
import {User} from './user';
import {Visit} from './visit.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  // Do wszystkich wizyt
  getUsers(): Observable<RootObject> {
    // api/user też by było ok, a nawet łatwiejsze, bo to już zostało zrobione jako lista :/
    return this.http.get<RootObject>(environment.apiUrl + 'api/users');
  }

  // Do jednej konkretnej
  getUser(userId): Observable<User> {
    return this.http.get<User>('http://localhost:8080/api/user/' + userId);
  }

  addUser(userObject): any {
    // tslint:disable-next-line:ban-types
    return this.http.post<Object>((environment.apiUrl + 'api/client/create'), userObject);
  }
}


export interface Gender {
    genderName: string;
  }

export interface Client {
    ownsAccount: boolean;
    visitsId: number[];
    _embedded: Embedded3;
  }

export interface Embedded3 {
  visits: Visit[];
  user: User;
}

// tslint:disable-next-line:no-empty-interface
export interface Employee {
  }

export interface Embedded2 {
    gender: Gender;
    client: Client;
    employee: Employee;
  }

export interface Self {
    href: string;
  }

export interface User2 {
    href: string;
  }

export interface Gender2 {
    href: string;
  }

export interface Client2 {
    href: string;
  }

export interface Employee2 {
    href: string;
  }

export interface Links {
    self: Self;
    user: User2;
    gender: Gender2;
    client: Client2;
    employee: Employee2;
  }

export interface User {
    firstName: string;
    lastName: string;
    address: string;
    contactNumber: string;
    otherInformation: string;
    userName: string;
    pesel: string;
    birthDate: string;
    isEmployee: boolean;
    isClient: boolean;
    _embedded: Embedded2;
    _links: Links;
  }

export interface Embedded {
    users: User[];
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
