import {Component, OnInit} from '@angular/core';
import {AccountService} from '../../services/account.service';
import {User} from '../../model/user';

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.component.css']
})
export class AccountsComponent implements OnInit {

  currentAccount: User;
  accounts: User[];
  showAccounts: boolean;
  showDetails: boolean;

  constructor(private accountService: AccountService) {
    this.accounts = [];
    this.currentAccount = new User();
    this.showAccounts = false;
    this.showDetails = false;
  }

  getAccounts(): void {
    this.accountService.getUsers().subscribe(value => {
      this.accounts = value;
      this.showAccounts = true;
    });
  }

  deleteAccount(): void {
    if (this.currentAccount.username == localStorage.getItem('username')) {
      alert('Can not delete the curently logged in account from here, go to your own account and try deleting from there.');
    } else {
      this.accountService.deleteUser(this.currentAccount.userId).subscribe(value => {
        this.getAccounts();
        this.showDetails = false;
      });
    }
  }

  selectAccount(i: number): void {
    this.currentAccount = this.accounts[i];
    this.showDetails = true;
  }

  ngOnInit(): void {
    this.getAccounts();
  }

}
