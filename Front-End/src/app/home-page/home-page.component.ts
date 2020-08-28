import { SrcDestService } from './../src-dest.service';
import { Component, OnInit } from '@angular/core';
import { Search } from "../search";
import { BusServiceService } from "../bus-service.service";
import { BusOutput } from "../busoutput";
@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
search:Search=new Search();
searcha:BusOutput[];
doj:any;
  constructor(private service:BusServiceService, private obj1:SrcDestService) { }

  ngOnInit(): void {
  }

  Pune: boolean= false;
  NaviMumbai: boolean= false;
  Dombivli: boolean= false;
  Nashik: boolean= false;
  showf=true;


  selectedsrc: any;

  handleEvent(event){
    this.selectedsrc= event.target.value;
    this.setFalse();

  }

  setFalse(){
    switch (this.selectedsrc) {
      case 'Pune': this.Pune = true;
        break;
      case 'NaviMumbai': this.NaviMumbai = true;
        break;
      case 'Dombivli': this.Dombivli = true;
        break;
      case 'Nashik': this.Nashik = true;
        break;
    }
  }


  handleClick(){   
    switch (this.selectedsrc) {
      case 'Pune': this.Pune = false;
        break;
      case 'NaviMumbai': this.NaviMumbai = false;
        break;
      case 'Dombivli': this.Dombivli = false;
        break;
      case 'Nashik': this.Nashik = false;
        break;
    }
  }
  busNumber:Number;
  checkUser:boolean=false;
  show(){
   this.showf=false;
   sessionStorage.setItem('doj', this.doj)
   sessionStorage.setItem('src',this.search.src)
   sessionStorage.setItem('dest',this.search.dest)
   
  }
  searchBus(){
   this.checkUser=true;
  this.search.typeOfUser="authorized";
  //alert(JSON.stringify(this.search))
  this.service.display(this.search).subscribe((searcha:BusOutput[])=>{
    this.searcha=searcha;
  })
  }
  searchBus1(){
    this.checkUser=true;
    this.search.typeOfUser="unauthorized";
    //alert(JSON.stringify(this.search))
    this.service.display(this.search).subscribe((searcha:BusOutput[])=>{
      this.searcha=searcha;
    })
    }
    

    busObj:BusOutput;
    showFun(c:BusOutput){
      this.busObj=c;
      sessionStorage.setItem("busNo",""+c.busNo);
      sessionStorage.setItem('pathNo',""+c.pathNo);
      sessionStorage.setItem('arrival',""+c.startTime);
      sessionStorage.setItem('depart',""+c.reachTime);
      sessionStorage.setItem('fare',""+c.fare);
    }

}
