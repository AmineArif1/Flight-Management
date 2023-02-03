package com.ensamvol.service;

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
}
