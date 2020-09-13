import { Component, Injectable, OnInit } from '@angular/core';
import {RootObject, Visit} from '../data/visit';
import {VisitService} from '../data/visit.service';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {Client} from '../data/user.service';

@Component({
  selector: 'app-visits',
  templateUrl: './visits.component.html',
  styleUrls: ['./visits.component.css']
})

export class VisitsComponent implements OnInit {

  constructor(private visitService: VisitService, private router: Router, private httpClient: HttpClient) { }

  visits: RootObject;

  // // tslint:disable-next-line:typedef
  // ngOnInit() {
  //   // this.visitService.getVisits().subscribe(visits => this.visits = visits);
  // }

  // // tslint:disable-next-line:typedef
  // toHomepage(){
  //   this.router.navigate(['/']);
  // }

  ngOnInit(): void {
    this.visitService.getVisits().subscribe(value => {
      this.visits = value;
      this.visits._embedded.visits.forEach(visit => {
        this.httpClient.get<Client>(visit._links.client.href).subscribe(client => {
          visit.clientName = client._embedded.user.firstName + ' ' +  client._embedded.user.lastName;
        });
      })

    });
    console.log();
  }
}
