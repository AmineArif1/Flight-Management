package com.ensamvol.service;

import com.ensamvol.entities.vol;
import com.ensamvol.repositories.VolRepository;

import java.util.List;

public class VolServiceImp implements  VolService{
    final VolRepository volRepository;

    public VolServiceImp(VolRepository volRepository) {
        this.volRepository = volRepository;
    }

    @Override
    public void addNewVol(vol vole) {
        volRepository.save(vole);

    }

    @Override
    public List<vol> listVol() {
        return volRepository.findAll();
    }

    @Override
    public void removeVol(Long idVol) {
        volRepository.deleteVolById(idVol);

    }

    @Override
    public void saveVol(vol vole) {
        volRepository.save(vole);

    }
}
