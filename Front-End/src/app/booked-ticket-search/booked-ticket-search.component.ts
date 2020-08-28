import { SearchTicket } from './../searchticket';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { ForbiddenNameValidator } from '../../assets/shared/user-name.validator';
import { PasswordValidator } from '../../assets/shared/password.validator';
import { ContactNumberValidator } from '../../assets/shared/contact-number.validator';
import { DataService } from '../data.service';
import {  BookedTiketSearch } from "../ticketNo";
import { BookedTicketOutput } from "../bookedTicketOutput";

import { BusServiceService } from "../bus-service.service";

@Component({
  selector: 'app-booked-ticket-search',
  templateUrl: './booked-ticket-search.component.html',
  styleUrls: ['./booked-ticket-search.component.css']
})
export class BookedTicketSearchComponent implements OnInit {
  title='Search Booked Ticket Page';

  //getter method for TicketId.
  get TicketId(){
    return this.SearchTicketForm.get('ticketId');
  }
  
  //constructor
  constructor(private fb: FormBuilder, private router: Router,private service: BusServiceService){}




  //declare variable of form group type.
  SearchTicketForm: FormGroup;
  submitted= false;
  show=false;


  //Oninit method.
  ngOnInit(){
    this.SearchTicketForm= this.fb.group({

      //TicketId Validator
      ticketId: ['',[Validators.required, Validators.minLength(1)]]

    });
  }



  search:BookedTiketSearch=new BookedTiketSearch();
  searchb:SearchTicket[];
  searchTicket(){
    this.show=true;
    //alert(JSON.stringify(this.search))
    this.service.bookedTicketSearch(this.search).subscribe((searchb:SearchTicket[])=>{
      this.searchb=searchb;
    })
    }

    
}