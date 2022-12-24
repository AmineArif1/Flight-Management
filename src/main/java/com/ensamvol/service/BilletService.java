package com.ensamvol.service;

import com.ensamvol.entities.Billet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BilletService {
    void addNewBillet(Billet billet);
    List<Billet> listBillet();
    void removeBillet(int idBillet);
    void saveBillet(Billet billet);
}

