package com.jobApplication.JobApplication.Impl;

import com.jobApplication.JobApplication.Repository.ReviewRepository;
import com.jobApplication.JobApplication.entity.Company;
import com.jobApplication.JobApplication.entity.Review;
import com.jobApplication.JobApplication.service.CompanyService;
import com.jobApplication.JobApplication.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService =companyService;

    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company!=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return  true;
        }
        return false;
    }
}
