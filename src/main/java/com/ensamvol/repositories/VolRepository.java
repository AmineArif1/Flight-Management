package com.ensamvol.repositories;

import com.ensamvol.entities.Vol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolRepository extends JpaRepository<Vol,Long> {
     void deleteVolByIdVol(Long idVol);

}
