import {Component, OnInit, ViewChild} from '@angular/core';
import {User} from '../model/user';
import {ActivatedRoute, Router} from '@angular/router';
import {SignupService} from '../services/signup.service';

class UserService {
}

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  user: User;
  err: any;
  @ViewChild('adduserForm') form: any;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private signupService: SignupService) {
    this.user = new User();
  }

  onSubmit(): void {

    this.signupService.addUser(this.user).subscribe(data => {
      if (data !== undefined) {
        if (data.userId !== undefined) {
          this.goToSuccess();
        }
      } else {
        this.form.reset();
        alert('Account creation failed. Either username already present in database or constraints violated.');
      }
    }, error => {
      console.log('opps', error);
    });
  }

  goToSuccess(): void {
    this.router.navigate(['']);
    alert('User created with the username: ' + this.user.username);
  }

  ngOnInit(): void {
  }

}
