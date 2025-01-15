import { ActorRole } from './contracts/actor-role';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import {Observable, of, Subject} from 'rxjs';
import {MovieSummary} from './contracts/movie-summary';
import {Movie} from "./contracts/movie";
import { Language } from './contracts/language';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private baseURL = "http://localhost:8080/api/v1/movies";

  constructor(private httpClient: HttpClient) { }

  getMoviesList(): Observable<MovieSummary[]>{
    return this.httpClient.get<MovieSummary[]>(`${this.baseURL}`);
  }

  createMovie(movie: Movie): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, movie);
  }

  getMovieById(id: number): Observable<Movie>{
    return this.httpClient.get<Movie>(`${this.baseURL}/${id}`);
  }

  updateMovie(id: number, movie: Movie): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, movie);
  }

  deleteMovie(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

  addActor(movieId:number, actor:ActorRole): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/${movieId}/actors`, actor);
  }

  getActorsList(movieId:number): Observable<ActorRole[]>{
    return this.httpClient.get<ActorRole[]>(`${this.baseURL}/${movieId}/actors`);
  }

  getlanguages():Observable<Language[]>{
    return this.httpClient.get<Language[]>(`${this.baseURL}/languages`);
  }
}
