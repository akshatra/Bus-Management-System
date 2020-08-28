import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { HttpClientModule } from "@angular/common/http";


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CancelTicketComponent } from './cancel-ticket/cancel-ticket.component';
import { AfterCancelButtonComponent } from './after-cancel-button/after-cancel-button.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BookedTicketSearchComponent } from './booked-ticket-search/booked-ticket-search.component';
import { BookedTicketDetailsComponent } from './booked-ticket-details/booked-ticket-details.component';
import { AboutPageComponent } from './about-page/about-page.component';
import { ForgotPasswordPageComponent } from './forgot-password-page/forgot-password-page.component';
import { HomePageComponent } from './home-page/home-page.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { SearchBusComponent } from './search-bus/search-bus.component';
import { CheckUserTypeComponent } from './check-user-type/check-user-type.component';
import { AuthorizedUserComponent } from './authorized-user/authorized-user.component';
import { UnauthorizedUserComponent } from './unauthorized-user/unauthorized-user.component';
import { SeatSelectLayoutComponent } from './seat-select-layout/seat-select-layout.component';
import { AfterSeatSelectComponent } from './after-seat-select/after-seat-select.component';
import { PaymentPortalComponent } from './payment-portal/payment-portal.component';


@NgModule({
  declarations: [
    AppComponent,
    CancelTicketComponent,
    AfterCancelButtonComponent,
    RegisterComponent,
    LoginComponent,
    DashboardComponent,
    BookedTicketSearchComponent,
    BookedTicketDetailsComponent,
    AboutPageComponent,
    ForgotPasswordPageComponent,
    HomePageComponent,
    AdminPageComponent,
    SearchBusComponent,
    CheckUserTypeComponent,
    AuthorizedUserComponent,
    UnauthorizedUserComponent,
    SeatSelectLayoutComponent,
    AfterSeatSelectComponent,
    PaymentPortalComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
