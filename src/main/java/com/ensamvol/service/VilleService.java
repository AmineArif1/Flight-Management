package com.ensamvol.service;

import com.ensamvol.entities.Ville;
import com.ensamvol.entities.Vol;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public interface VilleService {
    void addNewVille(Ville ville);
    List<Ville> listVille();
    void removeVille(Long idVille);
    void saveVille(Ville ville);
}
