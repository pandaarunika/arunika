import { Component, OnInit } from '@angular/core';
import { Asteroid } from '../../model/asteroid';
import { AsteroidService } from "../../services/asteroid.service";

@Component({
  selector: 'app-list-mining',
  templateUrl: './list-mining.component.html',
  styleUrls: ['./list-mining.component.css']
  
})
export class ListMiningComponent implements OnInit {

  public models:Asteroid[];
  constructor(private _asteroidservice: AsteroidService) { }
  ngOnInit() {
    this.list();
  }

 public  list(){
  this.models=this._asteroidservice.listMining();
 }
}
