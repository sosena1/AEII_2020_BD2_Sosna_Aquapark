import { Component, Injectable, OnInit } from '@angular/core';
import {Visit} from '../data/visit';
import {VisitService} from '../data/visit.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-visits',
  templateUrl: './visits.component.html',
  styleUrls: ['./visits.component.css']
})

export class VisitsComponent implements OnInit {

  visits: Visit[];

  constructor(private visitService: VisitService, private router: Router) { }

  ngOnInit(): void {
  }

  // // tslint:disable-next-line:typedef
  // ngOnInit() {
  //   // this.visitService.getVisits().subscribe(visits => this.visits = visits);
  // }

  // // tslint:disable-next-line:typedef
  // toHomepage(){
  //   this.router.navigate(['/']);
  // }
}
