import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-after-seat-select',
  templateUrl: './after-seat-select.component.html',
  styleUrls: ['./after-seat-select.component.css']
})
export class AfterSeatSelectComponent implements OnInit {

  constructor() { }
  busNumber:string=sessionStorage.getItem('busNo');
  source:string=sessionStorage.getItem('src');
  destion:string=sessionStorage.getItem('dest');
  doj:string=sessionStorage.getItem('doj');
  arrivalTime:string=sessionStorage.getItem('arrival');
  departureTime:string=sessionStorage.getItem('depart');
  seatNo:string=sessionStorage.getItem('seatNo');
  fare:string=sessionStorage.getItem('fare');

   /*
arriaval time
departure time
seatnumber
fare*/
  ngOnInit(): void {
  }

}
