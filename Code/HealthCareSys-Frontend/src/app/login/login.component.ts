import {Component, OnInit, ViewChild} from '@angular/core';
import {LoginDetails} from '../model/login-details';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthServiceService} from '../Helper/auth-service.service';
import {LoginService} from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: LoginDetails;
  @ViewChild('loginForm') form: any;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private auth: AuthServiceService,
              private login: LoginService) {
    this.user = new LoginDetails();
  }

  onSubmit(): void {
    this.login.login(this.user).subscribe(value => {
      if (this.user.username == localStorage.getItem('username')) {
        if (localStorage.getItem('role') == 'ROLE_USER') {
          this.router.navigate(['/userpanel']);
        } else if (localStorage.getItem('role') == 'ROLE_ADMIN') {
          this.router.navigate(['/adminpanel']);
        }

      } else {
        this.form.reset();
        alert('Check the username and password entered.');
      }
    });
  }

  ngOnInit(): void {
  }

}
