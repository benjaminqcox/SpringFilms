package com.bootcamp.learningSpring.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.learningSpring.domain.Review;
import com.bootcamp.learningSpring.services.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    
    private ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Review> create(@RequestBody Review review) {
        return new ResponseEntity<>(this.service.create(review), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<Review> getAllReviews() {
        return this.service.getAllReviews();
    }
}
