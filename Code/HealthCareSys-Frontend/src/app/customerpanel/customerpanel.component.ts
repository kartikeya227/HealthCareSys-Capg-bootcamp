import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-customer-panel',
  templateUrl: './customerpanel.component.html',
  styleUrls: ['./customerpanel.component.css']
})
export class CustomerpanelComponent implements OnInit {

  username: string;

  constructor() {
    this.username = localStorage.getItem('username');
  }

  ngOnInit(): void {
  }

}
