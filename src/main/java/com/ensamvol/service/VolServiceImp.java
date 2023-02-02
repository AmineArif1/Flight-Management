package com.ensamvol.service;

import com.ensamvol.entities.Vol;
import com.ensamvol.repositories.VolRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class VolServiceImp implements  VolService{
    final VolRepository volRepository;

    public VolServiceImp(VolRepository volRepository) {
        this.volRepository = volRepository;
    }

    @Override
    public void addNewVol(Vol vole) {
        volRepository.save(vole);

    }

    @Override
    public List<Vol> listVol() {
        return volRepository.findAll();
    }

    @Override
    public void removeVol(Long idVol) {
        volRepository.deleteVolByIdVol(idVol);

    }

    @Override
    public void saveVol(Vol vole) {
        volRepository.save(vole);

    }
}
