import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HeaderComponent } from './layout/header/header.component';
import { NavbarComponent } from './layout/navbar/navbar.component';
import { MaincontentComponent } from './layout/maincontent/maincontent.component';
import { FooterComponent } from './layout/footer/footer.component';
import { StartMiningComponent } from './mining/start-mining/start-mining.component';
import { EditMiningComponent } from './mining/edit-mining/edit-mining.component';
import { ListMiningComponent } from './mining/list-mining/list-mining.component';
import { AsteroidService } from "./services/asteroid.service";


const appRoutes: Routes = [
  { path: 'start', component: StartMiningComponent },
  { path: 'edit', component: EditMiningComponent },
  { path: 'list', component: ListMiningComponent },
  { path: '**', component: ListMiningComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavbarComponent,
    MaincontentComponent,
    FooterComponent,
    StartMiningComponent,
    EditMiningComponent,
    ListMiningComponent
   
  ],
  imports: [
    BrowserModule ,RouterModule.forRoot(appRoutes),FormsModule
  ],
  providers: [AsteroidService],
  bootstrap: [AppComponent]
})
export class AppModule { }
