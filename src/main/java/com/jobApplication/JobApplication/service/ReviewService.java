package com.jobApplication.JobApplication.service;

import com.jobApplication.JobApplication.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);
}
