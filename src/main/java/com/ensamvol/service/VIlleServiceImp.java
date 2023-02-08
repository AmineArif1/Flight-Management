package com.ensamvol.service;

import com.ensamvol.entities.Ville;
import com.ensamvol.repositories.VIlleRepository;
import com.ensamvol.repositories.VolRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class VIlleServiceImp implements VilleService{
    final VIlleRepository vIlleRepository;
    public VIlleServiceImp(VIlleRepository vIlleRepository) {
        this.vIlleRepository = vIlleRepository;
    }
    @Override
    public void addNewVille(Ville ville) {
        vIlleRepository.save(ville);
    }
    @Override
    public List<Ville> listVille() {

        return vIlleRepository.findAll();
    }
    @Override
    public void removeVille(Long idVille) {
        vIlleRepository.deleteVilleByIdville(idVille);
    }
    @Override
    public void saveVille(Ville ville) {
        vIlleRepository.save(ville);

    }
}
