package com.westeros.movies.updater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WesterosMoviesUpdaterApplication implements CommandLineRunner {

    @Autowired
    private IUpdateReviews updateReviews;

    public static void main(String[] args) {
        SpringApplication.run(WesterosMoviesUpdaterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Assuming there's a method to update movies
        updateMovies();
        updateReviews.updateReviews();
    }

    private void updateMovies() {
        // Logic to update movies
    }
}