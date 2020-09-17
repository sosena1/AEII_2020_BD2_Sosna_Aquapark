import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {UserService} from '../data/user.service';

@Component({
  selector: 'app-price-change',
  templateUrl: './price-change.component.html',
  styleUrls: ['./price-change.component.css']
})
export class PriceChangeComponent implements OnInit {

  // Html
  public name: string;
  public surname: string;
  public pesel: number;
  public genderId: number;
  public address: string;
  public contactNumber: number;
  public userName: string;
  public password: string;
  public birthDate: string;
  public otherInformation: string;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  submit(){
    console.log(
      this.name,
      this.surname,
      this.pesel,
      this.genderId,
      this.address,
      this.contactNumber,
      this.userName,
      this.password,
      this.birthDate,
      this.otherInformation);
    // Tworzenie obiektu
    const userObject: any = {
      name: this.name,
      surname: this.surname,
      pesel: this.pesel,
      genderId: this.genderId,
      address: this.address,
      contactNumber: this.contactNumber,
      userName: this.userName,
      password: this.password,
      birthDate: this.birthDate,
      otherInformation: this.otherInformation
    };
    this.userService.addUser(userObject).subscribe(data => console.log(data), exception => {
      if(exception.status === 400) {
        window.alert("Wprowadzono błędne dane")
      }
    });
  }
}
