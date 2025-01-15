import { Component, OnInit } from '@angular/core';
import { MovieSummary } from '../../contracts/movie-summary'
import { MovieService } from '../../movie.service'
import { Router } from '@angular/router';
@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  movies: MovieSummary[];

  constructor(private movieService: MovieService,
    private router: Router) { }

  ngOnInit(): void {
    this.getMovies();
  }

  private getMovies(){
    this.movieService.getMoviesList().subscribe(data => {
      this.movies = data;
    },
    error=>{
        alert(`
        z adresu: 
        HTTP GET http://localhost:8080/api/v1/movies

        potrzeba pobrać listę danych o filmach w postaci obiektu:
          MovieSummaryDto
          {
            id: number;
            title: string;
            homepage: string;
            language: string;
          }
        `)
    });
  }

  movieDetails(id: number){
    this.router.navigate(['movie-details', id]);
  }

  updateMovie(id: number){
    this.router.navigate(['update-movie', id]);
  }

  deleteMovie(id: number){
    this.movieService.deleteMovie(id).subscribe(data => {
      console.log(data);
      this.getMovies();
    },
    error=>{
          alert(
          `
          Z adresu: 
              http://localhost:8080/api/v1/movies/${id}
          
              HttP Method DELETE

          chcę usunąć film o id ${id}.
          `);})
  }
}
