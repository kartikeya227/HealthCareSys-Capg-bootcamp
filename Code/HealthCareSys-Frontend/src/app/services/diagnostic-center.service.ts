/** *
 * Service for Diagnostic Center Http requests
 * userUrl = 'http://localhost:9090/center';
 */
import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of, throwError} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';
import {DiagnosticCenter} from '../model/diagnostic-center';

@Injectable({
  providedIn: 'root'
})
export class DiagnosticCenterService {


  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };
  private centerUrl = 'http://localhost:9090/center';  // URL to web api

  constructor(private http: HttpClient) {
  }

  /** GET a list of all Diagnostic centers from the server */
  getDiagnosticCenter(): Observable<DiagnosticCenter[]> {
    const url = `${this.centerUrl}/all`;
    return this.http.get<DiagnosticCenter[]>(url)
      .pipe(
        tap(_ => this.log('Fetched Diagnostic Center')),
        catchError(err => {
          alert('Error occurred:\nCan not get list of all Diagnostic centers from backend.');
          this.handleError<DiagnosticCenter[]>(`GET all Diagnostic Center`);
          return throwError(err);
        })
      );
  }

  /** GET Diagnostic Center by id.
   * 404 if id not found
   */
  getDiagnosticCenterById(id: number): Observable<DiagnosticCenter> {
    const url = `${this.centerUrl}/find/${id}`;
    return this.http.get<DiagnosticCenter>(url).pipe(
      tap((diagnosticCenter: DiagnosticCenter) => this.log(`Fetched Diagnostic center Id: ${id}`)),
      catchError(err => {
        alert('Error occurred:\nCan not get Diagnostic center with center Id from backend.');
        this.handleError<DiagnosticCenter>(`Get Diagnostic Center by center Id.`);
        return throwError(err);
      })
    );
  }

  /** POST: add a new Diagnostic center to the database. */
  addDiagnosticCenter(diagnosticCenter: DiagnosticCenter): Observable<DiagnosticCenter> {
    const url = `${this.centerUrl}/add`;
    return this.http.post<DiagnosticCenter>(url, diagnosticCenter, this.httpOptions).pipe(
      tap((newDiagnosticCenter: DiagnosticCenter) => this.log(`Fetched Diagnostic center Id: ${newDiagnosticCenter.centerId}`)),
      catchError(err => {
        alert('Error occurred:\nCan not add the diagnostic center to the backend.');
        this.handleError<DiagnosticCenter>(`Add Diagnostic Center.`);
        return throwError(err);
      })
    );
  }


  /** DELETE: Delete the Diagnostic Center from the server */
  deleteDiagnosticCenter(id: number): Observable<DiagnosticCenter> {
    const url = `${this.centerUrl}/delete/${id}`;
    return this.http.delete<DiagnosticCenter>(url, this.httpOptions).pipe(
      tap(_ => this.log(`Deleted DiagnosticCenter with center id: ${id}.`)),
      catchError(err => {
        alert('Error occurred:\nCan not delete the center from the database. Center not found in database.');
        this.handleError<DiagnosticCenter>(`Delete DiagnosticCenter.`);
        return throwError(err);
      })
    );
  }

  /** PUT: update the Diagnostic Center on the server */
  updateDiagnosticCenter(diagnosticCenter: DiagnosticCenter): Observable<DiagnosticCenter> {
    const url = `${this.centerUrl}/update/${diagnosticCenter.centerId}`;
    return this.http.put(url, diagnosticCenter, this.httpOptions).pipe(
      tap((newDiagnosticCenter: DiagnosticCenter) => {
        this.log(`Updated Diagnostic center with center Id: ${newDiagnosticCenter.centerId}.`);
      }),
      catchError(err => {
        alert('Error occurred:\nCan not update the diagnostic center to the backend.');
        this.handleError<DiagnosticCenter>(`Update Diagnostic Center`);
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
