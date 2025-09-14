package com.jobApplication.JobApplication.Impl;

import com.jobApplication.JobApplication.Repository.ReviewRepository;
import com.jobApplication.JobApplication.entity.Review;
import com.jobApplication.JobApplication.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return null;
    }
}
