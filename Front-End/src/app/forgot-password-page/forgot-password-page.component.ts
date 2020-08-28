import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ForgotPassword } from '../forgotPassword';
import { CancelTicketStatus } from '../cancelTicketStatus';

import { BusServiceService } from "../bus-service.service";

@Component({
  selector: 'app-forgot-password-page',
  templateUrl: './forgot-password-page.component.html',
  styleUrls: ['./forgot-password-page.component.css']
})
export class ForgotPasswordPageComponent implements OnInit {

  constructor(private router: Router, private service: BusServiceService) { }

  afterSubmit:boolean = false;
  msg:string="submitted";

  ngOnInit(): void {
    
  }

  search:ForgotPassword=new ForgotPassword();
  searchb:CancelTicketStatus;
  forgotPassword(){
    //alert(JSON.stringify(this.search))
    this.service.forgotPassword(this.search).subscribe(data=>{
      if(data.status=="SUCCESS"){
        alert(data.message);
        this.router.navigate(['/']);
      }
      else{
        alert(data.message);
      }
    })
    }

}