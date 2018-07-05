import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BackendService } from '../../backend.service';
import { Movie } from '../../movie';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
id:string=null;
element:any=null;
editMovie:Movie=null;

  constructor(private route: ActivatedRoute,private _backendService:BackendService,private router:Router) { }

  ngOnInit() {
   /*  this.sub = this.route.params.subscribe(params => {
      this.id = +params['id']; }) */

      this.id=this.route.snapshot.paramMap.get('id');
      this.editMovie=this._backendService.editMovies(this.id);
      
  }

  updateMovie(editMovie):void{
    this._backendService.updateMovie(editMovie);
    this.router.navigate(['']);
  }
  /* ngOnDestroy() {
    this.sub.unsubscribe();
  } */
  

}
