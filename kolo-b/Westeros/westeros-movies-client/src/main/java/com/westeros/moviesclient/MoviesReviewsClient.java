package com.westeros.moviesclient;

import com.westeros.moviesclient.contract.ReviewDto;
import com.westeros.moviesclient.IMoviesReviewsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class MoviesReviewsClient implements IMoviesReviewsClient {

    @Value("b26b1824f9c2b3f8b222b4ac3cf48293")
    private String apiKey;

    private final RestTemplate restTemplate;

    public MoviesReviewsClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<ReviewDto> getReviews(Long movieId) {
        String url = String.format("https://api.themoviedb.org/3/movie/%d/reviews?api_key=%s", movieId, apiKey);
        ReviewResponse response = restTemplate.getForObject(url, ReviewResponse.class);
        return response != null ? response.getResults() : List.of();
    }

    private static class ReviewResponse {
        private List<ReviewDto> results;

        public List<ReviewDto> getResults() {
            return results;
        }

        public void setResults(List<ReviewDto> results) {
            this.results = results;
        }
    }
}