import { Injectable } from '@angular/core';
import jwt_decode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  newtoken: string;
  obj: any;
  constructor() { }
  public getToken(): string {
    if (localStorage.getItem('token') == null){
        this.newtoken = 'eyJhbGciOiJIUzUxMiJ9.eyJSb2xlIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJzdWIiOiJyYW0iLCJleHAiOjE2MDEzMzc2MTYsImlhdCI6MTYwMTMxOTYxNn0.q20tOvBOwx35ntrUo0zBT8pLm5ufXsN01NRW9jE_yKNp632o9nNxsb_m1pDQ9JxEL23RN5T2Nj8Bdh_oHAPvDA';
    }
    else {
      this.newtoken = localStorage.getItem('token');
      console.log('returning new token with value :-' + this.newtoken);
    }
    return this.newtoken;
  }
  public setToken(token: object): void{

    this.newtoken = token['token'];
    localStorage.setItem('token', this.newtoken);
    console.log(jwt_decode(this.newtoken));
    this.obj = jwt_decode(this.newtoken);
    localStorage.setItem('username',this.obj['sub']);
    localStorage.setItem('role', this.obj['Role'][0]['authority']);
    console.log('token stored succefully!');

  }
}
