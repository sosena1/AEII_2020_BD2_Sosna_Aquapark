import { Injectable } from '@angular/core';
import {Gender} from "./dao/gender";
import {GenderService} from "./services/gender.service";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {catchError} from "rxjs/operators";
import {throwError} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private genderService: GenderService, private http: HttpClient) {
    this.self = this;
  }
  isSignedIn(): boolean {
    return this.signedIn;
  }
  signIn(login: string, password: string): void {
    let plainLoginString = login + ":" + password;
    this.authString = window.btoa(plainLoginString);
    this.checkAuthData();
  }
  signOut(): void {
    this.authString = "";
    this.signedIn = false;
  }
  getAuthString(): string {
    return this.authString;
  }

  private checkAuthData(): void{
    this.http.get("http://localhost:8080/api/aquapark/genders", {observe: "response"}).pipe(catchError(this.handleError)).subscribe(response => {
      if(response.status == 200){
        console.log("AuthService: Successfully signed in");
        this.signedIn = true;
      }
    });

  }
  private handleError(error: HttpErrorResponse) {
    console.log("AuthService: Couldn't sign in with provided data");
    //TODO: Better deleting login variables
    this.authString = "";
    this.signedIn = false;
    return throwError('');
  }
  private authString: string = "";
  private signedIn: boolean = false;
  private self;
}
