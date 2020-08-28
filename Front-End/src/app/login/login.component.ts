import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { ForbiddenNameValidator } from '../../assets/shared/user-name.validator';
import { PasswordValidator } from '../../assets/shared/password.validator';
import { ContactNumberValidator } from '../../assets/shared/contact-number.validator';
import { Login } from '../login';
import { CancelTicketStatus } from '../cancelTicketStatus';
import { Router } from '@angular/router';

import { BusServiceService } from "../bus-service.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  title='Regsister Page';
  
  //getter method for Email.
  get Email(){
    return this.LoginForm.get('email');
  }

  //getter method for first name.
  get Password(){
    return this.LoginForm.get('password');
  }

  
  //constructor
  constructor(private fb: FormBuilder,private router: Router, private service: BusServiceService){}



  //declare variable of form group type.
  LoginForm: FormGroup;
  submitted= false;



  //Oninit method.
  ngOnInit(){
    this.LoginForm= this.fb.group({

      //Email Validator
      email: ['',[Validators.required, Validators.minLength(3), Validators.email]],


      //Password Validator
      password: ['',[Validators.required, Validators.minLength(8)]],

    });
  }

  //submit on click.
  onSubmit(){
    this.submitted = true;
    if (this.LoginForm.invalid) {
      this.LoginForm.markAsTouched(); //fields will remain marked once filled. Even after submit.
////            alert(this.registerForm.controls.fName.value);  <-- how to call the value of a field.   
      
      //for dashboard property
  }
    else{
      this.LoginForm.markAsTouched();
    }
  }

  search:Login=new Login();

  //sessionStorage.setItem('email', this.search.emailId);

  infoLogin:String;
  searchb:CancelTicketStatus;
  searchTicket(){
    // alert(JSON.stringify(this.search))
    sessionStorage.setItem('emailId', this.search.emailId);
    this.service.login(this.search).subscribe(data=>{
      if(data.status=="SUCCESS"){
        // alert(data.message);
        this.infoLogin=data.message;
        this.router.navigate(['/dashboardLink']);
      }
      else{
        this.infoLogin=data.message;
        //alert(data.message);
      }
    })
    }


}