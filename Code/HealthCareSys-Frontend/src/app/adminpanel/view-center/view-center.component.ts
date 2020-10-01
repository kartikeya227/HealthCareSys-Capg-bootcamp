import {Component, OnInit, ViewChild} from '@angular/core';
import {DiagnosticCenter} from '../../model/diagnostic-center';
import {DiagnosticCenterService} from '../../services/diagnostic-center.service';
import {TestDetails} from '../../model/test-details';

@Component({
  selector: 'app-view-center',
  templateUrl: './view-center.component.html',
  styleUrls: ['./view-center.component.css']
})
export class ViewCenterComponent implements OnInit {

  @ViewChild('addTestsForm') testsForm: any;
  @ViewChild('addCenterForm') centerForm: any;
  currentCenter: DiagnosticCenter;
  centers: DiagnosticCenter[];
  showCenters: boolean;
  showUpdate: boolean;
  showDetails: boolean;
  addTestShow: boolean;
  tests: TestDetails[];
  test: TestDetails;

  constructor(private centerService: DiagnosticCenterService) {
    this.showCenters = false;
    this.showDetails = false;
    this.showUpdate = false;
    this.addTestShow = false;
    this.currentCenter = new DiagnosticCenter();
    this.centers = [];
    this.tests = [];
    this.test = new TestDetails();
  }

  /**
   * Method to fetch all the Diagnostic centers from Database.
   */
  getCentersAll(): void {
    this.centerService.getDiagnosticCenter().subscribe(value => {
      this.centers = value;
      if (this.centers.length > 0) {
        this.showCenters = true;
        this.showDetails = false;
        this.showUpdate = false;
        this.addTestShow = false;

      }
    });
  }

  /**
   * Method to Update DOM with the details of currently clicked Center.
   */
  showCenterDetails(i: number): void {
    this.currentCenter = this.centers[i];
    this.showDetails = true;
    this.showUpdate = false;
    this.addTestShow = false;
  }

  /**
   * Method to call service for deleting the current selected centers from the database.
   */
  deleteCenter(): void {
    this.centerService.deleteDiagnosticCenter(this.currentCenter.centerId)
      .subscribe(value => {
        this.getCentersAll();
      });
  }

  /**
   * Method to update DOM with the form to take input for updating centers.
   */
  showUpdateCenter(): void {
    this.showUpdate = true;
    this.showDetails = false;
    this.addTestShow = false;

  }

  /**
   * Method to call service for updating centers in  database
   */
  updateCenter(): void {
    this.centerService.updateDiagnosticCenter(this.currentCenter)
      .subscribe(value => {
        this.getCentersAll();
      });
  }

  /**
   * Method to update DOM with the form to take input for adding test to center.
   */
  showAddTest(): void {
    this.showUpdate = false;
    this.showDetails = false;
    this.addTestShow = true;

  }

  /**
   * Method to push the details of test being added by Admin in a list.
   * resets the form every time on submission
   */
  addTests(): void {
    this.currentCenter.testList.push(this.test);
    this.tests.push(this.test);
    this.test = new TestDetails();
    this.testsForm.reset();
  }

  addTestToCenter(): void {
    this.centerService.updateDiagnosticCenter(this.currentCenter).subscribe(value => {
      this.getCentersAll();
    });
  }

  ngOnInit(): void {
    this.getCentersAll();
  }

}
