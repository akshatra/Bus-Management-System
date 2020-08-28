import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { SearchTicket } from "../searchticket";

@Component({
  selector: 'app-booked-ticket-details',
  templateUrl: './booked-ticket-details.component.html',
  styleUrls: ['./booked-ticket-details.component.css']
})
export class BookedTicketDetailsComponent implements OnInit {

  constructor(private service: DataService) { }

  ngOnInit(): void {
  }

  searchTicket:SearchTicket =new SearchTicket();

  message:any;

  bookedTicketsearch(){
      let resp=this.service.searchBookedTicket(this.searchTicket);
      resp.subscribe((data)=>this.message=data)
  }


}
