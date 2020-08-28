import { Reserve } from './Res';
import { allBook } from './allBookedSeat';
import { Available } from './availableSeats';
import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Search } from "./search";
import { BusOutput } from "./busoutput";
import { Observable } from 'rxjs';
import { BookedTiketSearch } from "./ticketNo";
import { SearchTicket } from "./searchticket";
import { User } from './user';
import { RegisterStatus } from './registerStatus';
import { CancelTicketStatus } from './cancelTicketStatus';
import { Login } from './login';
import { ForgotPassword } from './forgotPassword';
import { CancelTicket } from './cancelTicket';

@Injectable({
  providedIn: 'root'
})
export class BusServiceService {

  constructor(private http:HttpClient) { }

  display(search:Search):Observable<any>{
    let url="http://localhost:8587/searchbus";
    return this.http.post<BusOutput>(url,search);
  }

  bookedTicketSearch(ticketSearch:BookedTiketSearch):Observable<any>{
    let url="http://localhost:8587/searchticket";
    return this.http.post<SearchTicket>(url,ticketSearch);
  }

  availableSeats(findSeats:Available):Observable<any>{
    let url="http://localhost:8587/availableseats";
    return this.http.post<allBook>(url,findSeats);
  }
  
  makeReservation(resObj:Reserve):Observable<any>{
    let url="http://localhost:8587/addreservation";
    return this.http.post<string>(url,resObj);
  }
  
  register(user:User){
    let url="http://localhost:8587/addregistration";
    return this.http.post<RegisterStatus>(url,user);
  }

  login(login:Login){
    let url="http://localhost:8587/login";
    return this.http.post<CancelTicketStatus>(url,login);
  }

  forgotPassword(forgotPass:ForgotPassword){
    let url="http://localhost:8587/forgotpass";
    return this.http.post<CancelTicketStatus>(url,forgotPass);
  }

  cancelTicket(cancelTicket:CancelTicket){
    let url="http://localhost:8587/cancelticket";
    return this.http.post<CancelTicketStatus>(url,cancelTicket);
  }

}
