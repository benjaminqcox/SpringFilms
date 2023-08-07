package com.bootcamp.learningSpring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootcamp.learningSpring.domain.Review;
import com.bootcamp.learningSpring.repos.ReviewRepo;

@Service
public class ReviewService {

    private ReviewRepo repo;

    public ReviewService(ReviewRepo repo) {
        this.repo = repo;
    }

    public Review create(Review review) {
        return this.repo.save(review);
    }
    
    public List<Review> getAllReviews() {
        return this.repo.findAll();
    }
}
