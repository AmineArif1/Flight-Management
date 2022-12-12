package com.ensamvol.repositories;

import com.ensamvol.entities.Client;
import com.ensamvol.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientRepository extends JpaRepository<Client,String> {
    Client findByNumPassport(String num_passport);
    void deleteClientByNumPassport(String num_passport);

}
