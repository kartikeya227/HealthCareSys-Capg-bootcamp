import {Component, OnInit} from '@angular/core';
import {Appointment} from '../../model/appointment';
import {AppointmentService} from '../../services/appointment.service';

@Component({
  selector: 'app-view-appointment-customer',
  templateUrl: './view-appointment-customer.component.html',
  styleUrls: ['./view-appointment-customer.component.css']
})
export class ViewAppointmentCustomerComponent implements OnInit {

  currentAppointment: Appointment;
  appointments: Appointment[];
  showDetails: boolean;
  showAppointments: boolean;
  date: string;
  time: string;
  dateIn: Date;

  constructor(private appointmentService: AppointmentService) {
    this.currentAppointment = new Appointment();
    this.appointments = [];
    this.showDetails = false;
    this.showAppointments = false;
  }

  getAppointments(): void {
    this.appointmentService.getALLAppointmentByUser(Number(localStorage.getItem('userId'))).subscribe(value => {
      this.showAppointments = false;
      this.appointments = value;
      if (this.appointments.length > 0) {
        this.showAppointments = true;
      }
    });
  }

  showAppointmentDetails(i: number): void {
    this.currentAppointment = this.appointments[i];
    this.dateIn = new Date(this.currentAppointment.timestamp);
    this.date = this.dateIn.getDate() + '/' + (this.dateIn.getMonth() + 1) + '/' + this.dateIn.getFullYear();
    this.time = this.dateIn.getUTCHours() + ':' + this.dateIn.getUTCMinutes();
    this.showDetails = true;
  }

  deleteAppointment(): void {
    this.appointmentService.deleteAppointment(this.currentAppointment.appointmentId).subscribe(value => {
      this.getAppointments();
      this.showDetails = false;
    });
  }

  ngOnInit(): void {
    this.getAppointments();
  }

}
