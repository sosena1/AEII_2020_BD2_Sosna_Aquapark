import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../data/user.service';
import {User} from '../data/user';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  user: User;
  userId;

  constructor(private userService: UserService, private route: ActivatedRoute, private location: Location, private router: Router) {
  }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.userId = this.route.snapshot.paramMap.get('id');
    this.userService.getUser(this.userId).subscribe(vis => this.user = vis);
  }

  // tslint:disable-next-line:typedef
  returnButton() {
    // @ts-ignore
    this.router.navigate(['environment.apiUrl/api/users']);
    // this.router.navigate(['http://localhost:4200/api/visits/1/client');
  }
}
