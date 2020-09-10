import { Component, Injectable, OnInit } from '@angular/core';
import {RootObject, User} from '../data/user';
import {Router} from '@angular/router';
import {UserService} from '../data/user.service';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  constructor(private userService: UserService, private router: Router) { }

  users: RootObject;

  ngOnInit(): void {
    this.userService.getUsers().subscribe(value => {this.users = value; });
    // console.log();
  }

  // tslint:disable-next-line:typedef variable-name
  toUserDetails(number: number) {
    this.router.navigate(['/users/' + number]);
  }
}
