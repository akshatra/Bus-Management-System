import { Component, OnInit } from '@angular/core';
import {  FormBuilder, Validators, FormGroup } from '@angular/forms';

import { ForbiddenNameValidator } from '../../assets/shared/user-name.validator';
import { PasswordValidator } from '../../assets/shared/password.validator';
import { ContactNumberValidator } from '../../assets/shared/contact-number.validator';
import { CancelTicket } from '../cancelTicket';
import { CancelTicketStatus } from '../cancelTicketStatus';

import { BusServiceService } from "../bus-service.service";

@Component({
  selector: 'app-cancel-ticket',
  templateUrl: './cancel-ticket.component.html',
  styleUrls: ['./cancel-ticket.component.css']
})
export class CancelTicketComponent implements OnInit {
  title='Cancel Booked Ticket Page';
  search:CancelTicket=new CancelTicket();
  searchb:CancelTicketStatus;
  
  //getter method for Email.
  get Email(){
    return this.CancelTicketForm.get('email');
  }

  //getter method for TicketId.
  get TicketId(){
    return this.CancelTicketForm.get('ticketId');
  }
  
  //constructor
  constructor(private fb: FormBuilder,private service: BusServiceService){}



  //declare variable of form group type.
  CancelTicketForm: FormGroup;
  submitted= false;



  //Oninit method.
  ngOnInit(){
    this.CancelTicketForm= this.fb.group({

      //Email Validator
      email: ['',[Validators.required, Validators.minLength(5), Validators.email]],

      //TicketId Validator
      ticketId: ['',[Validators.required, Validators.minLength(3)]],

    });
  }

  infoCancel:String;
  cancelTicket(){
    //alert(JSON.stringify(this.search))
    this.service.cancelTicket(this.search).subscribe(data=>{
      //alert(data.message);
      this.infoCancel=data.message;
    })
    }
}