import {Component, Input, OnInit} from '@angular/core';
import {AuthServiceService} from '../Helper/auth-service.service';
import construct = Reflect.construct;

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  @Input() title: string;
  loginStatus: boolean;

  constructor(private auth: AuthServiceService) { }

  logout(): void {
    localStorage.clear();
    this.ngOnInit();
  }

  check(): void{
    this.ngOnInit();
  }

  ngOnInit(): void {
    this.loginStatus = this.auth.isLogin();
  }

}
