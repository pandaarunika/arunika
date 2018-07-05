import { Component, OnInit } from '@angular/core';
import { BackendService } from '../../backend.service';
import { Movie } from '../../movie';
@Component({
  selector: 'app-all',
  templateUrl: './all.component.html',
  styleUrls: ['./all.component.css']
})
export class AllComponent implements OnInit  {
  movies:Movie[];
  
  constructor(private _backendService:BackendService) { }

  ngOnInit(){
   this.movies=this._backendService.getMovies();
  }

}
