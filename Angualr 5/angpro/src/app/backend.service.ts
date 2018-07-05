import { Injectable } from '@angular/core';
import { Movie } from './movie';

@Injectable({
  providedIn: 'root'
})
export class BackendService {
  movies:Movie[]= [{"id":'1',"movieName":"The Incredibles" ,"year":1998,"rating":4},{"id":'2',"movieName":"CoCo" ,"year":2015,"rating":5}];
  editmovie:Movie=null;
  constructor(){
  }

  addMovies(m: Movie):void{
    this.movies.push(m);
  }

  getMovies():Movie[]{
       return this.movies ;
  }
  editMovies(id:string){
    this.movies.forEach(element => {
      if(element.id==id){
        this.editmovie=element;
      }
    });
    return this.editmovie;
  }
  updateMovie(editmovie):any{
    this.movies.forEach(element => {
      if(element.id==editmovie.id){
        element.movieName=editmovie.movieName;
        element.year=editmovie.year;
        element.rating=editmovie.rating;
      }
    });

  }
}
