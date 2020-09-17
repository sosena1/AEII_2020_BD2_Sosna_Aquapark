import { Component, OnInit } from '@angular/core';
import {AuthService} from '../auth.service';
import {GenderService} from '../services/gender.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private authService: AuthService, private genderService: GenderService) { }

  ngOnInit(): void {
  }

  authTest(): void {
    this.authService.signIn('Zonia', 'SXfQ173');
  }

}
