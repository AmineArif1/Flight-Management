package com.ensamvol.repositories;

import com.ensamvol.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AppUserRepository extends JpaRepository<Personne,String> {
    Personne findByUsername(String username);
    void deletePersonneByUsername(String username);
    Personne findByCIN(int CIN);

}
