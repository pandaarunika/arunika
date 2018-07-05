import { Component, OnInit } from '@angular/core';
import { BackendService } from '../../backend.service';
import { Movie } from '../../movie';
@Component({
  selector: 'app-top',
  templateUrl: './top.component.html',
  styleUrls: ['./top.component.css']
})
export class TopComponent implements OnInit  {
  movies:Movie[];
  
  constructor(private _backendService:BackendService) { }

  ngOnInit(){
   this.movies=this._backendService.getMovies();
  }

}
