package com.ensamvol.service;

import com.ensamvol.entities.Ville;
import com.ensamvol.entities.Vol;

import java.util.List;

public interface VilleService {
    void addNewVille(Ville ville);
    List<Ville> listVille();
    void removeVille(Long idVille);
    void saveVille(Ville ville);
}
