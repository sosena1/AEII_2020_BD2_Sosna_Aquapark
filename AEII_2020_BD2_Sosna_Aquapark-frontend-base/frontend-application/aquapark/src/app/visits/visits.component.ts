import { Component, Injectable, OnInit } from '@angular/core';
import {RootObject, Visit} from '../data/visit';
import {VisitService} from '../data/visit.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-visits',
  templateUrl: './visits.component.html',
  styleUrls: ['./visits.component.css']
})

export class VisitsComponent implements OnInit {

  constructor(private visitService: VisitService, private router: Router) { }

  visits: RootObject;

  // // tslint:disable-next-line:typedef
  // ngOnInit() {
  //   // this.visitService.getVisits().subscribe(visits => this.visits = visits);
  // }

  // // tslint:disable-next-line:typedef
  // toHomepage(){
  //   this.router.navigate(['/']);
  // }
  private inputString: string;

  ngOnInit(): void {
    this.visitService.getVisits().subscribe(value => {this.visits = value; });
    console.log();
  }
}
