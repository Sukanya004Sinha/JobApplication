package com.jobApplication.JobApplication.Repository;

import com.jobApplication.JobApplication.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {


}
