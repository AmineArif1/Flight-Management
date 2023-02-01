package com.ensamvol.repositories;

import com.ensamvol.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VIlleRepository extends JpaRepository<Ville,Integer> {
    void deleteVilleByIdville(Long idVille);

}
