import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MovieListComponent } from './movies-components/movie-list/movie-list.component';
import { CreateMovieComponent } from './movies-components/create-movie/create-movie.component';
import { UpdateMovieComponent } from './movies-components/update-movie/update-movie.component';
import { MovieDetailsComponent } from './movies-components/movie-details/movie-details.component';
import { CreateActorComponent } from './actor-components/create-actor/create-actor.component';

const routes: Routes = [
  {path: 'movies', component: MovieListComponent},
  {path: 'create-movie', component: CreateMovieComponent},
  {path: '', redirectTo: 'movies', pathMatch: 'full'},
  {path: 'update-movie/:id', component: UpdateMovieComponent},
  {path: 'movie-details/:id', component: MovieDetailsComponent},
  {path: 'movie-details/:id/add-actor', component: CreateActorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
