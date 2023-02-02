package com.ensamvol.service;

import com.ensamvol.entities.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    void addNewCompany(Company company);
    List<Company> listCompany();
    void removeCompany(Long idCompany);
    void saveCompany(Company company);

}
