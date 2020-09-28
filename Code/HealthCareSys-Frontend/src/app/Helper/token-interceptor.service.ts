import {Injectable, Type} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {AuthServiceService} from './auth-service.service';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorService implements HttpInterceptor {

  constructor(public auth: AuthServiceService) {}
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    request = request.clone({
      setHeaders: {
         Authorization: `Bearer ${this.auth.getToken()}`,
        'Content-Type': 'application/json'
      }
    });
    return next.handle(request);
  }
}
