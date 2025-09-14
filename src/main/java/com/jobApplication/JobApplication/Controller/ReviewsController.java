package com.jobApplication.JobApplication.Controller;

import com.jobApplication.JobApplication.entity.Review;
import com.jobApplication.JobApplication.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewsController {
    private ReviewService reviewService;

    public ReviewsController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long id) {
        return new ResponseEntity(reviewService.getAllReviews(id), HttpStatus.OK);
    }
}


/******
 * GET/companies/ {companyId}/reviews
 * POST/companies/{companyId}/ reviews
 * GET/companies/ {companyId}/reviews/{reviewId}
 * PUT/companies/ {companyId}/ reviews/ {reviewId}
 * DELETE/companies/{companyId}/reviews/{reviewId}
 */
