import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  isLoggedIn(): boolean {
    return this.loggedIn;
  }

  username: string = "";
  loggedIn: boolean = false;
}
