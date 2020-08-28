import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SearchBusComponent } from './search-bus/search-bus.component';
import { User } from "./user";
import { SearchTicket } from "./searchticket";

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) {

  }
  public doRegistration(user:User){
    return this.http.post("http://localhost:8587/addregistration",user,{responseType: 'text' as 'json'});
  }

  /*public searchBookedTicket(ticketNo : any):Observable<SearchTicket[]>{
    return this.http.get<SearchTicket[]>("http://localhost:8587/searchticket"+ticketNo,{responseType: 'any' as 'json'});
  }*/

  public searchBookedTicket(ticketNo){
    return this.http.get("http://localhost:8587/searchticket/"+ticketNo);
  }
}
