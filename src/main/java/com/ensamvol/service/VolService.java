package com.ensamvol.service;

import com.ensamvol.HelperClass.VolHelper;
import com.ensamvol.entities.Ville;
import com.ensamvol.entities.Vol;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface VolService {
    void addNewVol(Vol vole);

    List<Vol> listVol();

    void removeVol(Long idVol);

    void saveVol(Vol vole);

    Optional<Vol> getVolById(Long idVol);

    Ville getVilleDepart(Long idVol);
    Ville getVilleArrive(Long idVol);
	public void updateVol(VolHelper updatedVol);
}
