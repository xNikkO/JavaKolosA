import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MovieListComponent } from './movies-components/movie-list/movie-list.component';
import { CreateMovieComponent } from './movies-components/create-movie/create-movie.component';
import { FormsModule} from '@angular/forms';
import { UpdateMovieComponent } from './movies-components/update-movie/update-movie.component';
import { MovieDetailsComponent } from './movies-components/movie-details/movie-details.component'
import { CreateActorComponent } from './actor-components/create-actor/create-actor.component';
import {ActorsListComponent} from "./actor-components/actor-details/actors-list.component";

@NgModule({
  declarations: [
    AppComponent,
    MovieListComponent,
    CreateMovieComponent,
    UpdateMovieComponent,
    MovieDetailsComponent,
    CreateActorComponent,
    ActorsListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
