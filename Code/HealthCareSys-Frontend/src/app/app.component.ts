import {Component, OnInit} from '@angular/core';
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
  loginDetails: LoginDetails;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private authService: AuthServiceService,
              private loginService: LoginService) {
  this.loginDetails = new LoginDetails();
  this.loginDetails.username = 'ram';
  this.loginDetails.password = 'Ka1001Si!';
  }
  onClick(): void{
  this.loginService.login(this.loginDetails)
    .subscribe(value => {
      console.log('returned value from login servie: ' + JSON.stringify(value));
      console.log('localstorage value :-' + this.authService.getToken());
    });
  }

}
