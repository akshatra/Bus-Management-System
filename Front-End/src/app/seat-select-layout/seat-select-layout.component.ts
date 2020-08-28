import { Reserve } from './../Res';
import { SrcDestService } from './../src-dest.service';
import { Available } from './../availableSeats';
import { allBook } from './../allBookedSeat';
import { Component, OnInit } from '@angular/core';
import { BusServiceService } from '../bus-service.service';

@Component({
  selector: 'app-seat-select-layout',
  templateUrl: './seat-select-layout.component.html',
  styleUrls: ['./seat-select-layout.component.css']
})
export class SeatSelectLayoutComponent implements OnInit {

  constructor(private service:BusServiceService,private obj:SrcDestService) { }

  ngOnInit(): void {
  }
  
  searcha:allBook;
  search:Available=new Available();
  bookdedSeat:number[]=[];
  findTickets(){
   /* alert(sessionStorage.getItem("busNo"));
    alert(sessionStorage.getItem('doj'));
    alert(sessionStorage.getItem('src'));
    alert(sessionStorage.getItem('dest'));*/
  
    this.search.busNo=parseInt(sessionStorage.getItem("busNo"),10);
    this.search.doj=sessionStorage.getItem('doj');
    this.search.src=sessionStorage.getItem('src');
    this.search.dest=sessionStorage.getItem('dest');
    alert(JSON.stringify(this.search))
    this.service.availableSeats(this.search).subscribe((searcha:allBook)=>{
      this.searcha=searcha;
      console.log("Hello");
      console.log(this.searcha);
      console.log(typeof (this.searcha.seat[1]));
      for(let i=0;i<this.searcha.seat.length;i++){
        this.bookdedSeat[i]=this.searcha.seat[i];
      }
      console.log("everyone");
    })
   
    }

    searchT:Reserve=new Reserve();
    message:string;
    dt:string;
    seatNumber:String;
    email:string;
    phoneNo:string;
    makeReservation(){
      sessionStorage.setItem('seatNo',""+this.seatNumber);
      this.dt =  sessionStorage.getItem('doj');
     this.searchT.doj=this.dt;
      this.searchT.seatNo=""+this.seatNumber;
      this.searchT.pathNo=sessionStorage.getItem('pathNo');
      this.searchT.email=this.email;
      this.searchT.phone=this.phoneNo;
      alert(JSON.stringify(this.searchT))
      this.service.makeReservation(this.searchT).subscribe((message:string)=>{
        this.message=message;
        console.log("Hello");
      })

    }

}
