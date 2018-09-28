package com.avatech.edi.administrative.service;

import com.avatech.edi.administrative.model.bo.Company;
import com.avatech.edi.administrative.repository.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private ICompanyRepository companyRepository;

    public void saveCompany(List<Company> companyList){
        if(companyList == null || companyList.size() == 0)
            return;
        companyRepository.saveAll(companyList);
    }

    public List<Company> getCompanies(){
        return (List<Company>)companyRepository.findAll();
    }
}
