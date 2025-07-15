package com.jobApplication.JobApplication.Repository;

import com.jobApplication.JobApplication.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
