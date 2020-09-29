import {Injectable} from '@angular/core';
import jwt_decode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  newtoken: string;
  obj: any;

  constructor() {
  }

  public getToken(): string {
    if (localStorage.getItem('token') == null) {
      return '';
    } else {
      this.newtoken = localStorage.getItem('token');
      console.log('returning new token with value :-' + this.newtoken);
    }
    return this.newtoken;
  }

  public setToken(token: object): void {

    this.newtoken = token['token'];
    localStorage.setItem('token', this.newtoken);
    console.log(jwt_decode(this.newtoken));
    this.obj = jwt_decode(this.newtoken);
    localStorage.setItem('username', this.obj['sub']);
    localStorage.setItem('role', this.obj['Role'][0]['authority']);
    localStorage.setItem('userId',this.obj['UserId']);
    console.log('token stored succefully!');
  }

  public isLogin(): boolean {
    if (localStorage.getItem('token') == null) {
      return false;
    }
    return true;
  }
}
