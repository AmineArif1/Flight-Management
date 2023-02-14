package com.ensamvol.service;

import com.ensamvol.entities.Company;
import com.ensamvol.repositories.CompanyRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
@Service
@Transactional
public class CompanyServiceImp implements CompanyService {

    final CompanyRepository companyRepository;

    public CompanyServiceImp(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public void addNewCompany(Company company) {
        companyRepository.save(company);

    }

    @Override
    public List<Company> listCompany() {
        return companyRepository.findAll();
    }

    @Override
    public void removeCompany(Integer idCompany) {
        companyRepository.deleteCompanyByIdCompany(idCompany);

    }

    @Override
    public void saveCompany(Company company) {
        companyRepository.save(company);

    }
}
