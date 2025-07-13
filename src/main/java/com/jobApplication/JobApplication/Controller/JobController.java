package com.jobApplication.JobApplication.Controller;

import com.jobApplication.JobApplication.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        //return jobs;
        return ResponseEntity.ok(jobService.findAll());
    }
    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        //return "Job added Successfully";
        return new ResponseEntity<>("Job added Successfully", HttpStatus.OK);
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id ){

        Job job =jobService.getJobById(id);
        if(job!=null)
        return new ResponseEntity<>(job, HttpStatus.OK);
       // return new Job(1L, "TestJob", "TestJob", "2000", "2000", "Bangalore ");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}

/***
 * GET /jobs: Get all jobs
 * GET /jobs/{id}:Get a specific job id
 * POST/jobs : create a new job ( request body should contain the job details)
 * DELETE /jobs/{id}: Delete a specific job by ID
 * PUT/jobs/{id}:update a specific job by ID (request body should contain the updated  job
 *
 *
 * ExampleAPI URL's
 * GET {base_url}/jobs
 * GET {base_url}/jobs/1
 * POST {base_url}/jobs
 * DELETE {base_url}/jobs/1
 * PUT {base_url}/jobs/1
 *
 */