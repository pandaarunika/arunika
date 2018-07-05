import { Component, OnInit } from '@angular/core';
import { Movie } from '../../movie';
import { BackendService } from '../../backend.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  id:string=null;
  movieName:string=null;
  year:number=null; 
  rating:number=null;
  m:Movie;
  constructor(private _backend:BackendService,private router:Router) {
    
   }

  ngOnInit() {
  }
  
createMovie():void{
  this.m= new Movie(this.id,this.movieName,this.year,this.rating );
   this._backend.addMovies(this.m);
   this.router.navigate(['']);
  }
}
