package com.jobApplication.JobApplication.service;

import com.jobApplication.JobApplication.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    List<Company> getAllCompanies();

    boolean updateCompany(Company company, Long id);
    void createCompany(Company company);
    boolean deleteCompanyById(Long id);

    Company getCompanyById(Long id);
}


