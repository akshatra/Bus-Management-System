import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CancelTicketComponent } from "./cancel-ticket/cancel-ticket.component";
import { AfterCancelButtonComponent } from "./after-cancel-button/after-cancel-button.component";
import {  RegisterComponent} from "./register/register.component";
import { LoginComponent } from "./login/login.component";
import { DashboardComponent } from "./dashboard/dashboard.component";
import { BookedTicketSearchComponent } from "./booked-ticket-search/booked-ticket-search.component";
import { BookedTicketDetailsComponent } from "./booked-ticket-details/booked-ticket-details.component";
import { AboutPageComponent } from "./about-page/about-page.component";
import { ForgotPasswordPageComponent } from "./forgot-password-page/forgot-password-page.component"
import { HomePageComponent } from './home-page/home-page.component';
import { AdminPageComponent } from "./admin-page/admin-page.component";
import { CheckUserTypeComponent } from "./check-user-type/check-user-type.component";
import {  AuthorizedUserComponent} from "./authorized-user/authorized-user.component";
import { UnauthorizedUserComponent } from "./unauthorized-user/unauthorized-user.component";
import { SearchBusComponent } from "./search-bus/search-bus.component";
import { SeatSelectLayoutComponent } from "./seat-select-layout/seat-select-layout.component";
import { AfterSeatSelectComponent } from "./after-seat-select/after-seat-select.component";
import { PaymentPortalComponent } from "./payment-portal/payment-portal.component";

const routes: Routes = [
  {
     path:'',component:HomePageComponent
  },
  {
    path:'cancelLink', component: CancelTicketComponent
  },
  {
    path:'afterCancelButton', component: AfterCancelButtonComponent
  },
  {
    path:'registerLink', component: RegisterComponent
  },
  {
    path: 'loginLink', component: LoginComponent
  },
  {
    path: 'dashboardLink', component: DashboardComponent
  },
  {
    path: 'bookedTicketLink', component: BookedTicketSearchComponent
  },
  {
    path: 'ticketDetailsLink', component: BookedTicketDetailsComponent
  },
  {
    path: 'aboutPageLink', component: AboutPageComponent
  },
  {
    path: 'forgotPassLink', component: ForgotPasswordPageComponent
  },
  {
    path: 'adminPageLink', component: AdminPageComponent
  },
  {
    path: 'checkUserType', component: CheckUserTypeComponent
  },
  {
    path: 'authorizedUser', component: AuthorizedUserComponent
  },
  {
    path: 'unauthorizedUser', component: UnauthorizedUserComponent
  },
  {
    path: 'searchBusLink', component: SearchBusComponent
  },
  {
    path: 'seatLayoutLink', component: SeatSelectLayoutComponent
  },
  {
    path: 'afterSeatSelect', component: AfterSeatSelectComponent
  },
  {
    path: 'paymentPortalLink', component: PaymentPortalComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
