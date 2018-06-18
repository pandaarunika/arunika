import { Component, OnInit } from '@angular/core';
import { Asteroid } from '../../model/asteroid';
import { AsteroidService } from "../../services/asteroid.service";
import {Router} from '@angular/router';

@Component({
  selector: 'app-start-mining',
  templateUrl: './start-mining.component.html',
  styleUrls: ['./start-mining.component.css']

  
})
export class StartMiningComponent implements OnInit {
  public model:Asteroid = new Asteroid("","");
  constructor(private router: Router, private _asteroidservice: AsteroidService) { }

  ngOnInit() {
  }

 public  createMining(){
  this._asteroidservice.createMining(this.model);
  this.router.navigateByUrl('/list');
 }
 
}
