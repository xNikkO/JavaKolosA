import { Component, OnInit } from '@angular/core';
import {MovieService} from "../../movie.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ActorRole} from "../../contracts/actor-role";

@Component({
  selector: 'actors-list',
  templateUrl: './actors-list.component.html',
  styleUrls: ['./actors-list.component.css']
})
export class ActorsListComponent implements OnInit {

  id: number;
  actors: Array<ActorRole> = [];
  constructor(
    private movieService: MovieService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.movieService.getActorsList(this.id)
      .subscribe(
        data=>{
          this.actors=data;
        },
        error=>{
          alert(
            `
            Z adresu: 
                http://localhost:8080/api/v1/movies/${this.id}/actors
            
                HttP Method GET
    
            chcę pobrać listę postaci filmu w obiekcie ActorCharacterDto:
            {

              characterName: string;
              actorName: string;
            }
            `);}
          
      )
  }


}
