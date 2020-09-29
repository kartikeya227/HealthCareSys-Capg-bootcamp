import {Injectable} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthServiceService} from './auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class AuthgaurdUserService {

  constructor(private route: ActivatedRoute,
              private router: Router,
              private auth: AuthServiceService) {
  }

  /** *
   * Auth gaurd for Customer exclusive routes.
   */
  canActivate(): boolean {
    if (localStorage.getItem('role') == 'ROLE_USER' && this.auth.isLogin()) {
      return true;
    } else {
      alert('Login required to access the page.');
      this.router.navigate(['/login']);
      return false;
    }
  }
}
