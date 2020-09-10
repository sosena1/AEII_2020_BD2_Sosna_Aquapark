import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {VisitsComponent} from './visits/visits.component';
import {EmployeesComponent} from './employees/employees.component';
import {PriceChangeComponent} from './price-change/price-change.component';
import {VisitsAddComponent} from './visits-add/visits-add.component';
import {SigninComponent} from './signin/signin.component';
import {HomepageComponent} from './homepage/homepage.component';
import {UserDetailsComponent} from './employees/user-details.component';
// Zakomentować później, bo niepotrzebny routing do paska nawigacji
// import {NavbarComponent} from './navbar/navbar.component';


const routes: Routes = [
  {path: 'visitpage', component: VisitsComponent},
  {path: 'employees', component: EmployeesComponent},
  {path: 'price', component: PriceChangeComponent},
  {path: 'visitadd', component: VisitsAddComponent},
  {path: 'signin', component: SigninComponent},
  {path: 'homepage', component: HomepageComponent},
  {path: 'users/:id', component: UserDetailsComponent},
// Zakomentować później, bo niepotrzebny routing do paska nawigacji
//   {path: 'navbar', component: NavbarComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
