import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-servers',
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {
addButton='no server Added';
serverStatus=false;
  allowNewServer=false;
  serverName='';
  servers=['TestServer','TestServer2'];
  constructor() {
    setTimeout(() => { this.allowNewServer = true; }, 2000);
    
   }
   addEventListener(){
    
     this.serverStatus=true ;
     this.addButton='server Added is-----'+ this.serverName;
     this.servers.push(this.serverName);
   }
   onUpdate(event:Event){
     this.serverName=(<HTMLInputElement>event.target).value;
   }
  ngOnInit() {
  }

}
