package com.ensamvol.service;

import com.ensamvol.HelperClass.VolHelper;
import com.ensamvol.entities.Ville;
import com.ensamvol.entities.Vol;
import com.ensamvol.repositories.VIlleRepository;
import com.ensamvol.repositories.VolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VolServiceImp implements  VolService{
    final VolRepository volRepository;
    @Autowired 
    VIlleRepository villeRepository;

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
	public void updateVol(VolHelper updatedVol) {
        Vol vol = volRepository.findById(updatedVol.getIdVol()).orElse(null);
        Ville villeDepart= villeRepository.findByVilleName(updatedVol.villeDepart);
        System.out.println("villeDepartName"+updatedVol.villeDepart);
        System.out.println("villeDepart"+villeDepart);
        Ville villeArrive =villeRepository.findByVilleName(updatedVol.villeArrive);
        if (vol != null) {
        vol.setDateArrivee(updatedVol.getDateArrivee());
        vol.setDateDepart(updatedVol.getDateDepart());
        vol.setVolName(updatedVol.getVolName());
        vol.setVolImage(updatedVol.getVolImage());
        vol.setVolDescription(updatedVol.getVolDescription());
        vol.setVolPrix(updatedVol.getVolPrix());
        System.out.println("jsj"+updatedVol.getVilleDepart());
        vol.setVilleDepart(villeDepart);
        vol.setVilleArrive(villeArrive);

        volRepository.save(vol);
        }
    }




}
