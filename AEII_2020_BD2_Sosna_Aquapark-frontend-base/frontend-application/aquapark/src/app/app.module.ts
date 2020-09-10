import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { VisitsComponent } from './visits/visits.component';
import { VisitsAddComponent } from './visits-add/visits-add.component';
import { EmployeesComponent } from './employees/employees.component';
import { PriceChangeComponent } from './price-change/price-change.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatIconModule } from '@angular/material/icon';
import { SigninComponent } from './signin/signin.component';
import { HomepageComponent } from './homepage/homepage.component';

import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {BasicAuthInterceptor} from './helpers/basicauth.interceptor';
import {FormsModule} from "@angular/forms";
import { UserDetailsComponent } from './employees/user-details.component';


@NgModule({
  declarations: [
    AppComponent,
    VisitsComponent,
    VisitsAddComponent,
    EmployeesComponent,
    PriceChangeComponent,
    NavbarComponent,
    SigninComponent,
    HomepageComponent,
    UserDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: BasicAuthInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
