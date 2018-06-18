import { Injectable } from '@angular/core';
import { Asteroid } from '../model/asteroid';

@Injectable()
export class AsteroidService {
  models:Asteroid[] = [new Asteroid("aws-098","GOLD"),new Asteroid("pws-345","DIAMOND")];

  constructor() { }

  public  createMining(model: Asteroid){
    this.models.push(model);
  }
  public  editMining(model: Asteroid){
    for(let tmp of this.models){
      if(tmp.asteroidName==model.asteroidName){
        tmp.elementType=model.elementType;
        return;
      }
    }
  }
 public  listMining(): Asteroid[]{
        return this.models;
  }
public  completeMining(model: Asteroid){
  let i = 0;
  for(let tmp of this.models){
    if(tmp.asteroidName==model.asteroidName){
      this.models.splice(i,1);
      return;
    }
    i++;
  }
}
}
