import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../movie.service';
import { Movie } from '../../contracts/movie';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-movie',
  templateUrl: './update-movie.component.html',
  styleUrls: ['./update-movie.component.css']
})
export class UpdateMovieComponent implements OnInit {

  id: number;
  movie: Movie = new Movie();
  constructor(private movieService: MovieService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.movieService.getMovieById(this.id).subscribe(data => {
      this.movie = data;
    },
    error=>{
      alert(
        `
        Z adresu: 
            http://localhost:8080/api/v1/movies/${this.id}
        HttP Method GET

        chcę pobrać dane o filmie w postaci MovieDto:
        {
          id: number;
          title: string;
          homepage: string;
          language: string;  
          adult:boolean;
          budget:number;
          overview: string;
          releaseDate: Date;
          runtime: number;
          languageId:number;
        }
        `
    );});
  }

  onSubmit(){
    this.movieService.updateMovie(this.id, this.movie).subscribe(data =>{
      this.goToMoviesList();
    }
    , 
    error=>{
      alert(
        `
        Z adresu: 
            http://localhost:8080/api/v1/movies/${this.id}
        
            HttP Method PUT

        chcę zaktualizować dane o filmie w postaci MovieDto:
        {
          id: number;
          title: string;
          homepage: string;
          language: string;  
          adult:boolean;
          budget:number;
          overview: string;
          releaseDate: Date;
          runtime: number;
          languageId:number;
        }
        `
      );});
  }

  goToMoviesList(){
    this.router.navigate(['/movies']);
  }
}
