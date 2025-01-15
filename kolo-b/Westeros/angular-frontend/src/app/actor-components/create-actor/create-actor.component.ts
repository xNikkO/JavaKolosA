import { ActorRole } from './../../contracts/actor-role';
import { Component, OnInit } from '@angular/core';
import { MovieService } from 'src/app/movie.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'create-actor',
  templateUrl: './create-actor.component.html',
  styleUrls: ['./create-actor.component.css']
})
export class CreateActorComponent implements OnInit {


  actor : ActorRole = new ActorRole();
  id: number;

  constructor(
    private movieService: MovieService,
    private route: ActivatedRoute,
    private router: Router
    ) { }

  onSubmit() {
    this.movieService.addActor(this.id, this.actor).subscribe(
      data=>{
                    console.log(data);
                    this.router.navigate(['movie-details', this.id]);
                  } ,
                         error=>{
                    alert(
                      `
                      Z adresu: 
                          http://localhost:8080/api/v1/movies/${this.id}/actors
                      
                          HttP Method POST
              
                      chcę zapisać postać filmu. 
                      obiekt ActorCharacterDto:
                      {
                        characterName: string;
                        actorName: string;
                      }
                      `);});
  }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
  }

}
