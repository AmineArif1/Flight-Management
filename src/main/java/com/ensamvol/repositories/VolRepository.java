package com.ensamvol.repositories;

import com.ensamvol.entities.vol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolRepository extends JpaRepository<vol,Long> {
     void deleteVolByIdVol(Long idVol);

}
