import {Component, OnInit} from '@angular/core';
import {DiagnosticCenter} from '../../model/diagnostic-center';
import {Appointment} from '../../model/appointment';
import {AppointmentService} from '../../services/appointment.service';
import {DiagnosticCenterService} from '../../services/diagnostic-center.service';

@Component({
  selector: 'app-view-appointment-admin',
  templateUrl: './view-appointment-admin.component.html',
  styleUrls: ['./view-appointment-admin.component.css']
})
export class ViewAppointmentAdminComponent implements OnInit {

  centers: DiagnosticCenter[];
  currentAppointment: Appointment;
  appointments: Appointment[];
  showDetails: boolean;
  showCenters: boolean;
  showAppointments: boolean;
  currentCenter: DiagnosticCenter;
  date: string;
  time: string;
  dateIn: Date;

  constructor(private centerService: DiagnosticCenterService,
              private appointmentService: AppointmentService) {
    this.centers = [];
    this.currentAppointment = new Appointment();
    this.appointments = [];
    this.showDetails = false;
    this.showCenters = false;
    this.showAppointments = false;
    this.currentCenter = null;
  }

  getCenters(): void {
    this.centerService.getDiagnosticCenter().subscribe(value => {
      this.centers = value;
      if (this.centers.length > 0) {
        this.showCenters = true;
      }
    });
  }

  selectCenter(i: number): void {
    this.currentCenter = this.centers[i];
    this.getAppointments(this.currentCenter.centerId);
    this.showDetails = false;
  }

  getAppointments(centerId: number): void {
    this.appointmentService.getALLAppointmentByCenter(centerId).subscribe(value => {
      this.showAppointments = false;
      this.appointments = value;
      if (this.appointments.length > 0) {
        this.showAppointments = true;
      }
    });
  }

  showAppointmentDetails(i: number): void {
    this.currentAppointment = this.appointments[i];
    this.showDetails = true;
    this.dateIn = new Date(this.currentAppointment.timestamp);
    this.date = this.dateIn.getDate() + '/' + (this.dateIn.getMonth() + 1) + '/' + this.dateIn.getFullYear();
    this.time = this.dateIn.getHours() + ':' + this.dateIn.getMinutes();
  }

  deleteAppointment(): void {
    this.appointmentService.deleteAppointment(this.currentAppointment.appointmentId).subscribe(value => {
      this.getAppointments(this.currentCenter.centerId);
      this.showDetails = false;
    });
  }

  authorizeAppointment(): void {
    this.appointmentService.authorizeAppointment(this.currentAppointment).subscribe(value => {
      this.getAppointments(this.currentCenter.centerId);
      this.showDetails = false;
    });
  }

  ngOnInit(): void {
    this.getCenters();
  }

}
