import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';

import {AuthService} from '../auth.service';

@Injectable()
export class BasicAuthInterceptor implements HttpInterceptor {
  constructor(private authService: AuthService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // add authorization header with basic auth credentials if available
    console.log('Intercepting');
    const authString = this.authService.getAuthString();
    if (authString !== '') {
      request = request.clone({
        setHeaders: {
          Authorization: `Basic ${authString}`
        }
      });
    }

    return next.handle(request);
  }
}
