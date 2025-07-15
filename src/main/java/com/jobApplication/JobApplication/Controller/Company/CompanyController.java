package com.jobApplication.JobApplication.Controller.Company;

import com.jobApplication.JobApplication.entity.Company;
import com.jobApplication.JobApplication.service.CompanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }


}
