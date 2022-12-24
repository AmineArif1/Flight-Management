package com.ensamvol.service;

import com.ensamvol.entities.vol;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VolService {
    void addNewVol(vol vole);
    List<vol> listVol();
    void removeVol(Long idVol);
    void saveVol(vol vole);
}
