package com.ensamvol.repositories;

import com.ensamvol.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
    void deletCompanyById(Long idCompany);
}
