package com.jobApplication.JobApplication.service;

import com.jobApplication.JobApplication.Controller.Job;

import java.util.List;

public interface JobService {
   List<Job> findAll();
        void createJob(Job job);

    Job getJobById(Long id);
}
