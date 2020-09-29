/** *
 * Service for User Http requests
 * userUrl = 'http://localhost:9090/user';
 */
import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of, throwError} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';
import {User} from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };
  private userUrl = 'http://localhost:9090/user';  // URL to web api

  constructor(private http: HttpClient) {
  }

  /** GET Users from the server */
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.userUrl + '/all')
      .pipe(
        tap(_ => this.log('Fetched Users')),
        catchError(this.handleError<User[]>(`getUsers`, []))
      );
  }

  /** GET User by id. Will 404 if id not found */
  getUser(id: number): Observable<User> {
    const url = `${this.userUrl}/find/${id}`;
    return this.http.get<User>(url).pipe(
      tap(_ => this.log(`Fetched User Id: ${id}`)),
      catchError(this.handleError<User>(`getUser Id: ${id}`))
    );
  }

  /** DELETE: Delete the user from the server */
  deleteUser(id: number): Observable<User> {
    const url = `${this.userUrl + '/delete'}/${id}`;
    return this.http.delete<User>(url, this.httpOptions).pipe(
      tap(_ => this.log(`Deleted User id: ${id}`)),
      catchError(this.handleError<User>(`deleteUser`))
    );
  }

  /** PUT: update the hero on the server */
  updateUser(user: User): Observable<User> {
    const url = `${this.userUrl + '/update'}/${user.userId}`;
    return this.http.put(url, user, this.httpOptions).pipe(
      tap((newUser: User) => this.log(`Updated User with Id: ${newUser.userId}`)),
      catchError(err => {
        alert('Can not update the account with the updated values, posible violation of constraints.\nError:\n');
        this.handleError<User>(`updateUser`);
        return throwError(err);
      })
    );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T): any {
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
