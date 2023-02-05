package com.ensamvol.service;

import com.ensamvol.entities.Billet;
import com.ensamvol.entities.Client;
import com.ensamvol.repositories.BilletRepository;
import com.ensamvol.repositories.ClientRepository;
import com.ensamvol.repositories.VolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImp implements DashboardService{
    @Autowired
    private BilletRepository billetRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private VolRepository volRepository;
    @Override
    public double totalRevenue() {
        double sumRevenue = 0;
        for (Client client: clientRepository.findAll()){
        for (Billet b:client.getBillet())
              {
                  sumRevenue+=b.getBilletPrix();

        }
        }
        return sumRevenue;
    }

    @Override
    public double totalBillet() {
        double totalBillet = 0;
        for (Client client: clientRepository.findAll()){
            totalBillet+=client.getBillet().size();
        }
        return totalBillet;
    }

    @Override
    public Integer totalFlights() {
        return volRepository.findAll().size() ;
    }

    @Override
    public Integer totalClients() {
        return clientRepository.findAll().size();
    }
}
