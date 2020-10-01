import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-customer-landing',
  templateUrl: './customer-landing.component.html',
  styleUrls: ['./customer-landing.component.css']
})
export class CustomerLandingComponent implements OnInit {

  username: string;

  constructor() {
    this.username = localStorage.getItem('username');
  }

  ngOnInit(): void {
  }

}
