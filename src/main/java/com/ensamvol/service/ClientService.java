package com.ensamvol.service;


import com.ensamvol.entities.Client;
import com.ensamvol.entities.Role;
import com.ensamvol.entities.Personne;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public interface ClientService {

    void addNewClient(Client client);
    Client findByNumPassport(String num_passport);
    List<Client> listClient();
    void removeClient(String num_passport);
    void saveClient(Client client);
    Personne loadUserClient(int id);


}

