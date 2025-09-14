package com.jobApplication.JobApplication.Repository;

import com.jobApplication.JobApplication.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {


    List<Review> findByCompanyId(Long companyId);
}
