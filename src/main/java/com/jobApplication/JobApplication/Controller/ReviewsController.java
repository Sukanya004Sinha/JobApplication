package com.jobApplication.JobApplication.Controller;

import com.jobApplication.JobApplication.entity.Review;
import com.jobApplication.JobApplication.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewsController {
    private ReviewService reviewService;

    public ReviewsController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }
    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review) {
        boolean isReviewsaved = reviewService.addReview(companyId, review);
        if (isReviewsaved) {
            return new ResponseEntity<>("Review added successfully", HttpStatus.OK);


        } else {
            return new ResponseEntity<>("Review Not saved successfully", HttpStatus.NOT_FOUND);
        }
    }
}


/******
 * GET/companies/ {companyId}/reviews
 * POST/companies/{companyId}/ reviews
 * GET/companies/ {companyId}/reviews/{reviewId}
 * PUT/companies/ {companyId}/ reviews/ {reviewId}
 * DELETE/companies/{companyId}/reviews/{reviewId}
 */
