import {Component, OnInit} from '@angular/core';
import {User} from '../model/user';
import {ActivatedRoute, Router} from '@angular/router';
import {AccountService} from '../services/account.service';

@Component({
  selector: 'app-account-details',
  templateUrl: './account-details.component.html',
  styleUrls: ['./account-details.component.css']
})
export class AccountDetailsComponent implements OnInit {

  userDetails: User;
  userDetailsDisplay: User;
  userId: number;
  showUpdate: boolean;
  role: string;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private userService: AccountService) {
    this.userDetails = new User();
    this.userDetailsDisplay = new User();
    this.role = localStorage.getItem('role');
  }

  /**
   * Method to call service for deleting the current user
   * navigates to home page when user is deleted
   */
  deleteAccount(): void {
    this.userService.deleteUser(Number(localStorage.getItem('userId'))).subscribe(value => {
      localStorage.clear();
      this.router.navigate(['']);
      alert('Account with userId:' + value.userId + ' has been deleted.');
    });
  }

  /**
   * Method to Update DOM with Update user segment
   */
  updateAccount(): void {
    this.userDetails = this.userDetailsDisplay;
    this.showUpdate = true;
  }

  /**
   * Method to call service for update the current user
   */
  confirmUpdateAccount(): void {
    this.userService.updateUser(this.userDetails).subscribe(value => {
      this.userDetailsDisplay = value;
      this.showUpdate = false;
    });
  }


  ngOnInit(): void {
    this.userService.getUser(Number(localStorage.getItem('userId'))).subscribe(value => {
      this.userDetailsDisplay = value;
      console.log(value);
    });
    this.showUpdate = false;
  }

}
