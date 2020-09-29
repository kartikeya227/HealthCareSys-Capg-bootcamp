import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthServiceService} from './Helper/auth-service.service';
import {LoginService} from './services/login.service';
import {LoginDetails} from './model/login-details';
declare var jQuery: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  {
  @Input() title: string;

  constructor() {
    this.title = 'DebuggerLabs';
  }

}
