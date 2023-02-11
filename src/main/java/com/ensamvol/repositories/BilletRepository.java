package com.ensamvol.repositories;

import com.ensamvol.entities.Billet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BilletRepository extends JpaRepository<Billet,String> {
    void deleteBilletsByIdBillet( int  idBillet);
    @Query("SELECT b FROM Billet b ORDER BY b.idBillet DESC")
    List<Billet> xd();
}
