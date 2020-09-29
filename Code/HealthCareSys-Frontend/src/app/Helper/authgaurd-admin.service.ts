import {Injectable} from '@angular/core';
import {AuthServiceService} from './auth-service.service';
import {ActivatedRoute, Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthgaurdAdminService {

  constructor(private route: ActivatedRoute,
              private router: Router,
              private auth: AuthServiceService) {
  }

  /** *
   * Auth gaurd for ADMIN exclusive routes.
   */
  canActivate(): boolean {
    if (localStorage.getItem('role') == 'ROLE_ADMIN' && this.auth.isLogin()) {
      return true;
    } else {
      alert('Login required to access the page.');
      this.router.navigate(['/login']);
      return false;
    }
  }
}
