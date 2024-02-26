package com.example.springProject.repository;

import com.example.springProject.model.DiningReview;
import com.example.springProject.model.ReviewStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


@Repository
public interface DiningReviewRepository extends JpaRepository<DiningReview, Long> {
    List<DiningReview> findByRestaurantId(Long restaurantId);
    List<DiningReview> findByReviewStatus(ReviewStatus reviewStatus);
    List<DiningReview> findByRestaurantIdAndReviewStatus(Long restaurantId, ReviewStatus reviewStatus);

}
