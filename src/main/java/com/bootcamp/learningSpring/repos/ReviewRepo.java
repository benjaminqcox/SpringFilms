package com.bootcamp.learningSpring.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.learningSpring.domain.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {
    
}
