package com.ensamvol.service;

import com.ensamvol.entities.Client;
import com.ensamvol.entities.Personne;
import com.ensamvol.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImp implements ClientService {
    final ClientRepository clientRepository ;
    final AccountService accountService;
    public ClientServiceImp(ClientRepository clientRepository, AccountService accountService) {
        this.clientRepository = clientRepository;
        this.accountService = accountService;
    }

    @Override
    public void addNewClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client findByNumPassport(String num_passport) {
        return clientRepository.findByNumPassport(num_passport);
    }

    @Override
    public List<Client> listClient() {
        return clientRepository.findAll();
    }

    @Override
    public void removeClient(String num_passport) {
        clientRepository.deleteClientByNumPassport(num_passport);
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }
    public Personne loadUserClient(int id){
        return accountService.showUserById(id);

    }
}
