import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-admin-panel-landing',
  templateUrl: './admin-panel-landing.component.html',
  styleUrls: ['./admin-panel-landing.component.css']
})
export class AdminPanelLandingComponent implements OnInit {

  username: string;

  constructor() {
    this.username = localStorage.getItem('username');
  }

  ngOnInit(): void {
  }

}
