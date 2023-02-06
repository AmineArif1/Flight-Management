package com.ensamvol.service;

import com.ensamvol.entities.Ville;
import com.ensamvol.entities.Vol;
import com.ensamvol.repositories.VolRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    @Override
    public Optional<Vol> getVolById(Long idVol)
    {
    	return volRepository.findById(idVol);
    }
    @Override
    public Ville getVilleDepart(Long idVol){
        Vol tempVol = volRepository.findById(idVol).get();
        return tempVol.getVilleDepart();



    }

    @Override
    public Ville getVilleArrive(Long idVol) {
        Vol tempVol = volRepository.findById(idVol).get();
        return tempVol.getVilleArrive();
    }
    @Override
	public void updateVol(Long idVol, Vol updatedVol) {
        Vol vol = volRepository.findById(idVol).orElse(null);
        if (vol != null) {

        vol.setDateArrivee(updatedVol.getDateArrivee());
        vol.setDateDepart(updatedVol.getDateDepart());
        vol.setVolName(updatedVol.getVolName());
        vol.setVolImage(updatedVol.getVolImage());
        vol.setVolDescription(updatedVol.getVolDescription());
        vol.setVolPrix(updatedVol.getVolPrix());
        vol.setVilleDepart(updatedVol.getVilleDepart());
        vol.setVilleArrive(updatedVol.getVilleArrive());

        volRepository.save(vol);
        }
    }




}
