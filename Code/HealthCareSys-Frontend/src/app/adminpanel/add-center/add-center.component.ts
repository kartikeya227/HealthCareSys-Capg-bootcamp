import {Component, OnInit, ViewChild} from '@angular/core';
import {TestDetails} from '../../model/test-details';
import {ActivatedRoute, Router} from '@angular/router';
import {DiagnosticCenter} from '../../model/diagnostic-center';
import {DiagnosticCenterService} from '../../services/diagnostic-center.service';

@Component({
  selector: 'app-add-center',
  templateUrl: './add-center.component.html',
  styleUrls: ['./add-center.component.css']
})
export class AddCenterComponent implements OnInit {

  tests: TestDetails[];
  test: TestDetails;
  center: DiagnosticCenter;
  @ViewChild('addTestsForm') testsForm: any;
  @ViewChild('addCenterForm') centerForm: any;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private centerService: DiagnosticCenterService) {
    this.tests = new Array();
    this.test = new TestDetails();
    this.center = new DiagnosticCenter();
  }

  /**
   * Method to push the details of test being added by Admin in a list.
   * resets the form every time on submission
   */
  addTests(): void {
    this.tests.push(this.test);
    this.test = new TestDetails();
    this.testsForm.reset();
  }
  addCenter(): void{
    this.center.testList = this.tests;
    this.centerService.addDiagnosticCenter(this.center).subscribe(value =>{
      alert('new center made\n' + value);
      this.router.navigate(['viewcenter']);
    });
  }

  ngOnInit(): void {
  }

}
