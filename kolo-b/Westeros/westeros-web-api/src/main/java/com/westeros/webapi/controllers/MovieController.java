package com.westeros.webapi.controllers;

import com.westeros.webapi.contract.ActorCharacterDto;
import com.westeros.webapi.contract.MovieDto;
import com.westeros.webapi.services.IMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final IMovieService movieService;

    @PostMapping
    public ResponseEntity saveMovie(@RequestBody MovieDto movie){
        var id = movieService.saveMovie(movie);
        return ResponseEntity.ok(id);
    }
    @GetMapping
    public ResponseEntity getMovies(){
        var movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }
    @GetMapping("/{id}")
    public ResponseEntity getMovieById(@PathVariable("id") long id){
        var movie = movieService.getMovie(id);
        return ResponseEntity.ok(movie);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovieById(@PathVariable("id") long id){
        movieService.deleteMovieById(id);
        return ResponseEntity.ok(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity updateMovieById(@RequestBody MovieDto movieDto, @PathVariable("id")long id){
        var movie = movieService.updateMovie(id, movieDto);
        return ResponseEntity.ok(movie);
    }
    @GetMapping("/{id}/actors")
    public ResponseEntity getActorsFromMovie(@PathVariable("id") long id){
        var actors = movieService.getActorsInMovie(id);
        return ResponseEntity.ok(actors);
    }
    @GetMapping("/languages")
    public ResponseEntity getLanguages(){
        var languages = movieService.getLanguagaes();
        return ResponseEntity.ok(languages);
    }
    @PostMapping("/{id}/actors")
    public ResponseEntity saveActor(@RequestBody ActorCharacterDto actorCharacterDto, @PathVariable("id")long id){
        var actorId = movieService.saveActor(actorCharacterDto, id);
        return ResponseEntity.ok(actorId);
    }
}
