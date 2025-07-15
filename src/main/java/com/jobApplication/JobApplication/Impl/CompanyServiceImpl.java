package com.jobApplication.JobApplication.Impl;

import com.jobApplication.JobApplication.Repository.CompanyRepository;
import com.jobApplication.JobApplication.entity.Company;
import com.jobApplication.JobApplication.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService {


    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    public List<Company> getAllCompanies(){
        return  companyRepository.findAll();
    }
}
