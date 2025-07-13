package com.jobApplication.JobApplication.Controller;

import com.jobApplication.JobApplication.entity.Job;
import com.jobApplication.JobApplication.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        //return jobs;
        return ResponseEntity.ok(jobService.findAll());
    }
    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        //return "Job added Successfully";
        return new ResponseEntity<>("Job added Successfully", HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id ){

        Job job =jobService.getJobById(id);
        if(job!=null)
        return new ResponseEntity<>(job, HttpStatus.OK);
       // return new Job(1L, "TestJob", "TestJob", "2000", "2000", "Bangalore ");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean deleted = jobService.deleteJobById(id);
        if (deleted) {
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    //@RequestMapping(value = "/jobs/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id, updatedJob);
        if(updated)
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
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