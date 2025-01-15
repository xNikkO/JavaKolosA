package com.westeros.moviesclient;

import com.westeros.moviesclient.contract.ReviewDto;
import java.util.List;

public interface IMoviesReviewsClient {
    List<ReviewDto> getReviews(Long movieId);
}