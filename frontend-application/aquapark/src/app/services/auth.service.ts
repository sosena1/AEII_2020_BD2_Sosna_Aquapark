import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private username: string = "";
  private loggedIn: boolean = false;

  constructor() { }

  public isLoggedIn(): boolean {
    return this.loggedIn;
  }
}
