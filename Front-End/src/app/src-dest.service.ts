import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SrcDestService {

  constructor() { }

  src:String;
  dest:String;
  doj:String;
  busNo:number;

  getDoj(){
    return this.getDoj;
  }
  setDoj(value:String){
    this.doj=value;
  }
  getBusNo(){
    return this.busNo;
  }
  setBusNo(value:number){
    this.busNo = value;
  }
  getSrc(){
    return this.src;
  }
  setSrc(value:String){
    this.src=value;
  }
  getDest(){
    return this.dest;
  }
  setDest(value:String){
    this.dest = value;
  }
}
