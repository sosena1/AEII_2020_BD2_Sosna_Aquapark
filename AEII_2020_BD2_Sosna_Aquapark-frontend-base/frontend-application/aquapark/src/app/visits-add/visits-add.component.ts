import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {VisitService} from '../data/visit.service';

@Component({
  selector: 'app-visits-add',
  templateUrl: './visits-add.component.html',
  styleUrls: ['./visits-add.component.css']
})
export class VisitsAddComponent implements OnInit {

  // Moje html
  public userid: number;
  public identificatorid: number;
  constructor(private visitService: VisitService, private router: Router) { }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  moveFurther() {
    console.log(this.userid, this.identificatorid);
    // Tworzenie nowego obiektu userId z pól userid
    // Tworzenie obiektu to tylko to co jest w klamrach
    // v1
    // this.visitService.addVisit({userId: this.userid, identificatorId: this.identificatorid});

    // v2
    const visitObject: any = {
      userId: this.userid,
      identificatorId: this.identificatorid
    };
    // this.visitService.addVisit(visitObject);
    this.visitService.addVisit(visitObject).subscribe(data => console.log(data));

    // this.router.navigate(['/users/' + emptyField]);
  }

}


