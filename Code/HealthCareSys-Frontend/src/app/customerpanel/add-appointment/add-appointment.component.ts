import {Component, OnInit, ViewChild} from '@angular/core';
import {Appointment} from '../../model/appointment';
import {User} from '../../model/user';
import {DiagnosticCenter} from '../../model/diagnostic-center';
import {TestDetails} from '../../model/test-details';
import {AppointmentService} from '../../services/appointment.service';
import {DiagnosticCenterService} from '../../services/diagnostic-center.service';
import {AccountService} from '../../services/account.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-add-appointment',
  templateUrl: './add-appointment.component.html',
  styleUrls: ['./add-appointment.component.css']
})
export class AddAppointmentComponent implements OnInit {

  appointment: Appointment;
  centers: DiagnosticCenter[];
  selectedUser: User;
  selectedCenter: DiagnosticCenter;
  selectedTest: TestDetails;
  showCenter: boolean;
  showTest: boolean;
  datetime: string;
  @ViewChild('addAppointmentForm') centerForm: any;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private appointmentService: AppointmentService,
              private centerService: DiagnosticCenterService,
              private accountService: AccountService) {
    this.appointment = new Appointment();
    this.selectedCenter = new DiagnosticCenter();
    this.selectedCenter.testList = [];
    this.selectedCenter.centerId = 0;
    this.selectedTest = new TestDetails();
    this.selectedTest.testId = 0;
    this.selectedUser = null;
    this.centers = [];
  }

  getCenter(): void {
    this.centerService.getDiagnosticCenter().subscribe(value => {
      this.centers = value;
      this.showCenter = true;
    });
  }

  getUser(): void {
    this.accountService.getUser(Number(localStorage.getItem('userId'))).subscribe(value => {
      this.selectedUser = value;
    });
  }

  choiceCenter(i: number): void {
    this.selectedCenter = this.centers[i];
  }

  choiceTest(i: number): void {
    this.selectedTest = this.selectedCenter.testList[i];
  }

  makeAppointment(): void {
    this.appointment.approved = false;
    this.appointment.user = this.selectedUser;
    this.appointment.diagnosticCenter = this.selectedCenter;
    this.appointment.test = this.selectedTest;
    this.appointmentService.addAppointment(this.appointment).subscribe(value => {
      alert('Appointment made with the appointment Id: ' + value.appointmentId);
      this.router.navigate(['viewappointmentcustomer']);
    });
  }

  ngOnInit(): void {
    this.getCenter();
    this.getUser();
  }

}
