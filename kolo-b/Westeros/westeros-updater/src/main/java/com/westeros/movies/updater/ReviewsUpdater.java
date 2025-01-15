package com.westeros.movies.updater;

import com.westeros.data.model.Movie;
import com.westeros.data.model.Review;
import com.westeros.data.repositories.MoviesRepository;
import com.westeros.data.repositories.ReviewsRepository;
import com.westeros.moviesclient.IMoviesReviewsClient;
import com.westeros.moviesclient.contract.ReviewDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsUpdater implements IUpdateReviews {

    private final ReviewsRepository reviewsRepository;
    private final IMoviesReviewsClient reviewsClient;
    private final MoviesRepository movieRepository;

    public ReviewsUpdater(ReviewsRepository reviewsRepository, IMoviesReviewsClient reviewsClient, MoviesRepository movieRepository) {
        this.reviewsRepository = reviewsRepository;
        this.reviewsClient = reviewsClient;
        this.movieRepository = movieRepository;
    }

    @Override
    public void updateReviews() {
        List<Movie> movies = movieRepository.findAll();
        for (Movie movie : movies) {
            List<ReviewDto> reviewDtos = reviewsClient.getReviews(movie.getId());
            for (ReviewDto reviewDto : reviewDtos) {
                Review review = new Review();
                review.setContent(reviewDto.getContent());
                review.setRating(0); // Assuming rating is not provided in ReviewDto
                review.setMovie(movie);
                reviewsRepository.save(review);
            }
        }
    }
}