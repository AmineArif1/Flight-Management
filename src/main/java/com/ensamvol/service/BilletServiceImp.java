package com.ensamvol.service;

import com.ensamvol.entities.Billet;
import com.ensamvol.repositories.BilletRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BilletServiceImp implements BilletService {
    final BilletRepository billetrepository ;

    public BilletServiceImp(BilletRepository billetrepository) {
        this.billetrepository = billetrepository;
    }


    @Override
    public void addNewBillet(Billet billet) {
        billetrepository.save(billet);
    }

    @Override
    public List<Billet> listBillet() {
        return billetrepository.findAll();
    }

    @Override
    public void removeBillet(int idBillet) {
        billetrepository.deteleBilletById(idBillet);

    }

    @Override
    public void saveBillet(Billet billet) {
        billetrepository.save(billet);

    }
}
