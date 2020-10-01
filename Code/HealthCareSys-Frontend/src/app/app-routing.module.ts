import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {SignupComponent} from './signup/signup.component';
import {LandingComponent} from './landing/landing.component';
import {AuthgaurdAdminService} from './Helper/authgaurd-admin.service';
import {AuthgaurdUserService} from './Helper/authgaurd-user.service';
import {AddCenterComponent} from './adminpanel/add-center/add-center.component';
import {ViewAppointmentAdminComponent} from './adminpanel/view-appointment-admin/view-appointment-admin.component';
import {ViewCenterComponent} from './adminpanel/view-center/view-center.component';
import {AddAppointmentComponent} from './customerpanel/add-appointment/add-appointment.component';
import {ViewAppointmentCustomerComponent} from './customerpanel/view-appointment-customer/view-appointment-customer.component';
import {AccountDetailsComponent} from './account-details/account-details.component';
import {AdminPanelLandingComponent} from './adminpanel/admin-panel-landing/admin-panel-landing.component';
import {AccountsComponent} from './adminpanel/accounts/accounts.component';
import {CustomerLandingComponent} from './customerpanel/customer-landing/customer-landing.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent},
  {path: '', component: LandingComponent},
  {path: 'userpanel', component: CustomerLandingComponent, canActivate: [AuthgaurdUserService]},
  {path: 'adminpanel', component: AdminPanelLandingComponent, canActivate: [AuthgaurdAdminService]},
  {path: 'addcenter', component: AddCenterComponent, canActivate: [AuthgaurdAdminService]},
  {path: 'viewappointmentadmin', component: ViewAppointmentAdminComponent, canActivate: [AuthgaurdAdminService]},
  {path: 'viewcenter', component: ViewCenterComponent, canActivate: [AuthgaurdAdminService]},
  {path: 'addappointment', component: AddAppointmentComponent, canActivate: [AuthgaurdUserService]},
  {path: 'viewappointmentcustomer', component: ViewAppointmentCustomerComponent, canActivate: [AuthgaurdUserService]},
  {path: 'accountdetailscustomer', component: AccountDetailsComponent, canActivate: [AuthgaurdUserService]},
  {path: 'accountdetailsadmin', component: AccountDetailsComponent, canActivate: [AuthgaurdAdminService]},
  {path: 'accounts', component: AccountsComponent, canActivate: [AuthgaurdAdminService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
