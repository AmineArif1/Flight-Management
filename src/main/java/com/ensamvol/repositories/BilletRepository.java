package com.ensamvol.repositories;

import com.ensamvol.entities.Billet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilletRepository extends JpaRepository<Billet,String> {
    void deleteBilletsByIdBillet( int  idBillet);
}
