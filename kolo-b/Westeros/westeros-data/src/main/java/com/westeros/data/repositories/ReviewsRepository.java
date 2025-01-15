package com.westeros.data.repositories;

import com.westeros.data.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Review, Long> {
}