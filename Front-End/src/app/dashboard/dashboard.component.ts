import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { JsonPipe } from '@angular/common';
import { RegisterStatus } from '../registerStatus';
import { BusServiceService } from "../bus-service.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private http:HttpClient,private service: BusServiceService) { }

  emailId : string= sessionStorage.getItem('emailId')
   
  first:boolean=false;
  second:boolean=false;
  third:boolean=false;
  fourth:boolean=false;
  fifth:boolean=true;

  ngOnInit(): void {
  }
  
  showc(){
    this.first=false;
    this.second=false;
    this.third=true;
    this.fourth=false;
    this.fifth=false;
  }
 
newObj :sendEmail= new sendEmail()

amount:number;
  wallet(){
    //this.fourth=true;
    this.first=false;
    this.second=false;
    this.third=false;
    this.fourth=true;
    this.fifth=false;
    this.newObj.email = this.emailId
    this.http.post<any> ('http://localhost:8587/walletbalance',this.newObj)
    .subscribe(data => {
        this.amount = data
      }
)
  }

  newObj2 :sendEmail= new sendEmail()

  firstName:string;
  lastName;string;
  email:string;
  phone:number;
  userDetails(){
    //this.fourth=true;
    this.first=false;
    this.second=true;
    this.third=false;
    this.fourth=false;
    this.fifth=false;
    this.newObj2.email = this.emailId
    //alert(this.newObj2.email)
    this.http.post<any> ('http://localhost:8587/userdetails',this.newObj2)
    .subscribe(data => {
        this.firstName = data.firstName
        this.lastName= data.lastName
        this.email=data.email
        this.phone=data.phone
      }
)
  }

  newObj3 :sendEmail1= new sendEmail1()

  details:string;
  bookingDetails(){
    //this.fourth=true;
    this.first=true;
    this.second=false;
    this.third=false;
    this.fourth=false;
    this.fifth=false;
    this.newObj3.emailId = this.emailId
    this.http.post<any> ('http://localhost:8587/allbookedticket',this.newObj3)
    .subscribe(data => {
        this.details = data
        console.log(data)
      }
)
  }

  newObj1 :UpdatePassword= new UpdatePassword();
  oldPass:string;
  newPass:string;
  message:string;
  status:string;
  updatePass()
    {
      this.first=false;
      this.second=false;
      this.third=true;
      this.fourth=false;
      this.fifth=false;
      this.newObj1.email = this.emailId;
      this.http.post<any> ('http://localhost:8587/updatepassword',this.newObj1)
      .subscribe(data => {
          this.message = data.message
          this.status=data.status
          if(this.status=="SUCCESS"){
            console.log(this.message);
          }
          else{
            console.log(this.message);
          }
        }
      )
    }
  

}

class sendEmail{
  public email:string
}


class sendEmail1{
  public emailId:string
}

class UpdatePassword{
  email:string;
  oldPassword:string;
  newPassword:string;
}