package com.ensamvol.repositories;

import com.ensamvol.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    void deleteCompanyByIdCompany(Long idCompany);
}
