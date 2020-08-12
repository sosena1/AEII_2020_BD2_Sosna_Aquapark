import { Component, OnInit } from '@angular/core';
import {AuthService} from "../services/auth.service";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(authService: AuthService) {
    this.authService = authService;
  }

  ngOnInit(): void {
  }

  isSignedIn(): boolean {
    return this.authService.isLoggedIn();
  }

  authService: AuthService;
}
