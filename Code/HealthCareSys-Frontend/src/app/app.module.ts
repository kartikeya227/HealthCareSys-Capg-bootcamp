import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {LandingComponent} from './landing/landing.component';
import {LoginComponent} from './login/login.component';
import {SignupComponent} from './signup/signup.component';
import {NavbarComponent} from './navbar/navbar.component';
import {AdminpanelComponent} from './adminpanel/adminpanel.component';
import {CustomerpanelComponent} from './customerpanel/customerpanel.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {TokenInterceptorService} from './Helper/token-interceptor.service';
import {LoginService} from './services/login.service';
import {AuthServiceService} from './Helper/auth-service.service';
import {FormsModule} from '@angular/forms';
import {AddCenterComponent} from './adminpanel/add-center/add-center.component';
import {ViewCenterComponent} from './adminpanel/view-center/view-center.component';
import {AddAppointmentComponent} from './customerpanel/add-appointment/add-appointment.component';
import {AccountDetailsComponent} from './account-details/account-details.component';
import {ViewAppointmentCustomerComponent} from './customerpanel/view-appointment-customer/view-appointment-customer.component';
import {ViewAppointmentAdminComponent} from './adminpanel/view-appointment-admin/view-appointment-admin.component';
import {AdminPanelLandingComponent} from './adminpanel/admin-panel-landing/admin-panel-landing.component';
import {AccountsComponent} from './adminpanel/accounts/accounts.component';
import {CustomerLandingComponent} from './customerpanel/customer-landing/customer-landing.component';

@NgModule({
  declarations: [
    AppComponent,
    LandingComponent,
    LoginComponent,
    SignupComponent,
    NavbarComponent,
    AdminpanelComponent,
    CustomerpanelComponent,
    AddCenterComponent,
    ViewCenterComponent,
    AddAppointmentComponent,
    AccountDetailsComponent,
    ViewAppointmentCustomerComponent,
    ViewAppointmentAdminComponent,
    AdminPanelLandingComponent,
    AccountsComponent,
    CustomerLandingComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    },
    LoginService,
    AuthServiceService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
