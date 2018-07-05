import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { NavbarComponent } from './navbar/navbar.component';

import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './body/home/home.component';
import { AddComponent } from './body/add/add.component';
import { EditComponent } from './body/edit/edit.component';
import { RouterModule, Routes } from '@angular/router';
import { BackendService } from './backend.service';
import { FormsModule } from '@angular/forms';
import { RatingComponent } from './body/rating/rating.component';
import { AllComponent } from './body/all/all.component';
import { TopComponent } from './body/top/top.component';
import { ChildComponent } from './body/home/child/child.component';



const appRoutes: Routes = [
  //{ path: '', redirectTo: '/home/all', pathMatch: 'full' },
  { path: '', component: HomeComponent,
  children: [  
    //{ path: '', redirectTo: '/all', pathMatch: 'full' },
    {
        path:'top',
        component: TopComponent
    },
   
    {
        path:'',
        component: AllComponent
    },
]},
  { path: 'add',      component: AddComponent },
  { path: 'edit', component: EditComponent },
  { path: 'edit/:id', component: EditComponent},
  
  
  

];


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    AddComponent,
    EditComponent,
    RatingComponent,
    AllComponent,
    TopComponent,
    ChildComponent
    
  
  ],
  imports: [
    BrowserModule, RouterModule.forRoot(appRoutes),FormsModule
  ],
  providers: [BackendService],
  bootstrap: [AppComponent]
})
export class AppModule { }
