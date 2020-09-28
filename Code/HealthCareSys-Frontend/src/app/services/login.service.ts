/** *
 * Service for Login Http request
 * bookingsUrl = 'http://localhost:9090/authenticate';
 */
import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';
import {LoginDetails} from '../model/login-details';
import {AuthServiceService} from '../Helper/auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };
  private loginUrl = 'http://localhost:9090/authenticate';  // URL to web api


  constructor(private http: HttpClient,
              private authService: AuthServiceService) {
  }

  /** POST: sending Login details to get the JWT TOKEN to the server */
  login(logindetails: LoginDetails): Observable<any> {
    return this.http.post<any>(this.loginUrl, logindetails, this.httpOptions)
      .pipe(map(token => {
        // store user details and jwt token in local storage to keep user logged in between page refreshes
        this.authService.setToken(token);
      }));
  }


  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  private log(message: string): void {
    console.log('Server message:' + message);
  }

}
