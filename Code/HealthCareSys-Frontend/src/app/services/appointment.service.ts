import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of, throwError} from 'rxjs';
import {DiagnosticCenter} from '../model/diagnostic-center';
import {catchError, tap} from 'rxjs/operators';
import {User} from '../model/user';
import {Appointment} from '../model/appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };
  private appointmentUrl = 'http://localhost:9090/appointment';  // URL to web api

  constructor(private http: HttpClient) {
  }

  /** GET a list of all Appointments from the server */
  getALLAppointment(): Observable<Appointment[]> {
    const url = `${this.appointmentUrl}/all`;
    return this.http.get<Appointment[]>(url)
      .pipe(
        tap(_ => this.log('Fetched all Appointments')),
        catchError(err => {
          alert('Error occurred:\nCan not get list of all Appointments from the backend.');
          this.handleError<Appointment[]>(`GET all Appointment`);
          return throwError(err);
        })
      );
  }

  /** GET a list of all Appointments by user Id from the server */
  getALLAppointmentByUser(userId: number): Observable<Appointment[]> {
    const url = `${this.appointmentUrl}/byuser/${userId}`;
    return this.http.get<Appointment[]>(url)
      .pipe(
        tap(_ => this.log(`Fetched all Appointments By User Id:${userId}`)),
        catchError(err => {
          alert('Error occurred:\nCan not get list of all Appointments from the backend.');
          this.handleError<Appointment[]>(`GET all Appointment by user Id.`);
          return throwError(err);
        })
      );
  }

  /** GET a list of all Diagnostic centers from the server */
  getALLAppointmentByCenter(centerId: number): Observable<Appointment[]> {
    const url = `${this.appointmentUrl}/bycenter/${centerId}`;
    return this.http.get<Appointment[]>(url)
      .pipe(
        tap(_ => this.log(`Fetched Appointments by center Id: ${centerId}`)),
        catchError(err => {
          alert('Error occurred:\nCan not get list of all Appointments from the backend.');
          this.handleError<Appointment[]>(`GET all Appointment by center Id.`);
          return throwError(err);
        })
      );
  }

  /** GET Appointment by id.
   * 404 if id not found
   */
  getAppointmentById(id: number): Observable<Appointment> {
    const url = `${this.appointmentUrl}/find/${id}`;
    return this.http.get<Appointment>(url).pipe(
      tap((appointment: Appointment) => this.log(`Fetched Appointment Id: ${appointment.appointmentId}`)),
      catchError(err => {
        alert('Error occurred:\nCan not get Appointment with Appointment Id from backend.');
        this.handleError<Appointment>(`Get Appointment by Id.`);
        return throwError(err);
      })
    );
  }

  /** POST: add a new Appointment to the database. */
  addAppointment(appointment: Appointment): Observable<Appointment> {
    const url = `${this.appointmentUrl}/add`;
    return this.http.post<Appointment>(url, appointment, this.httpOptions).pipe(
      tap((newAppointment: Appointment) => this.log(`Fetched Appointment Id: ${newAppointment.appointmentId}`)),
      catchError(err => {
        alert('Error occurred:\nCan not add the Appointment  to the backend.');
        this.handleError<User[]>(`Add Appointment.`);
        return throwError(err);
      })
    );
  }


  /** DELETE: Delete the Appointment Center from the server */
  deleteAppointment(id: number): Observable<Appointment> {
    const url = `${this.appointmentUrl}/delete/${id}`;
    return this.http.delete<Appointment>(url, this.httpOptions).pipe(
      tap(_ => this.log(`Deleted Appointment with id: ${id}.`)),
      catchError(err => {
        alert('Error occurred:\nCan not delete the Appointment from the database. Appointment not found in database.');
        this.handleError<Appointment>(`Delete Appointment.`);
        return throwError(err);
      })
    );
  }

  /** PUT: Update the  Center on the server */
  updateAppointment(appointment: Appointment): Observable<Appointment> {
    const url = `${this.appointmentUrl}/update/${appointment.appointmentId}`;
    return this.http.put(url, appointment, this.httpOptions).pipe(
      tap((newAppointment: Appointment) => {
        this.log(`Updated Appointment with center Id: ${newAppointment.appointmentId}.`);
      }),
      catchError(err => {
        alert('Error occurred:\nCan not update the Appointment to the backend.');
        this.handleError<DiagnosticCenter>(`Update Appointment`);
        return throwError(err);
      })
    );
  }

  /** PUT: Update the  Center on the server */
  authorizeAppointment(appointment: Appointment): Observable<Appointment> {
    const url = `${this.appointmentUrl}/approve/${appointment.appointmentId}`;
    return this.http.put(url, appointment, this.httpOptions).pipe(
      tap((newAppointment: Appointment) => {
        this.log(`Authorized Appointment with center Id: ${newAppointment.appointmentId}.`);
      }),
      catchError(err => {
        alert('Error occurred:\nCan not Authorize the Appointment to the backend.');
        this.handleError<DiagnosticCenter>(`Authorize Appointment`);
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
