package com.westeros.movies.controllers;

import com.westeros.movies.updater.IUpdateMovies;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("updater")
public class UpdaterController {

    final IUpdateMovies updater;

    public UpdaterController(IUpdateMovies updater) {
        this.updater = updater;
    }

    @GetMapping("start")
    public ResponseEntity start(@RequestParam LocalDate from, @RequestParam LocalDate to){
        updater.updateByDateRange(from, to);

        return ResponseEntity.ok("Update started on "+ LocalDateTime.now());
    }
}
