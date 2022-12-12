package com.ensamvol.service;





import com.ensamvol.entities.Role;
import com.ensamvol.entities.Personne;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public interface AccountService {

    Personne addNewUser(Personne personne);
    Personne showUserById(int id);
    Role addNewRole(Role ROle);
    void addRoleToUser(String username,String roleName);
    Personne loadUserByUsername(String username);
    List<Personne> listUsers();
    List<Role> listRoles();
    void removeUser(String username);
    Personne OneUserById(String id);
    void saveUser(Personne user);
    List<Role> loadUserRoles(String username);


}

