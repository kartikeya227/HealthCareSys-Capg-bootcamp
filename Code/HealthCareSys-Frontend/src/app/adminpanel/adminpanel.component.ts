import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './adminpanel.component.html',
  styleUrls: ['./adminpanel.component.css']
})
export class AdminpanelComponent implements OnInit {

  username: string;
  constructor() {
    this.username = localStorage.getItem('username');
  }

  ngOnInit(): void {
  }

}
