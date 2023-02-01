package com.ensamvol.service;




import com.ensamvol.repositories.AppRoleRepository;
import com.ensamvol.repositories.AppUserRepository;
import com.ensamvol.entities.Role;
import com.ensamvol.entities.Personne;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
    private final  PasswordEncoder passwordEncoder;


    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Personne addNewUser(Personne personne) {
        String pw = personne.getPassword();
        personne.setPassword(passwordEncoder.encode(pw));
        return appUserRepository.save(personne);
    }

    @Override
    public Personne showUserById(int id) {
        return appUserRepository.findByCIN(id);
    }

    @Override
    public Role addNewRole(Role role) {
        return appRoleRepository.save(role);
    }
    @Override
    public void addRoleToUser(String username, String roleName) {
        Personne personne = appUserRepository.findByUsername(username);
        Role role = appRoleRepository.findByRoleName(roleName);

        personne.getRoles().add(role);
        appUserRepository.save(personne);


    }
    @Override
    public Personne loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<Personne> listUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public List<Role> listRoles() {
        return appRoleRepository.findAll();
    }

    @Override
    public void removeUser(String username) {
        appUserRepository.deletePersonneByUsername(username);
    }

    @Override
    public List<Role> loadUserRoles(String username) {
        Personne user = appUserRepository.findByUsername(username);
        return user.getRoles();
    }
    @Override
    public Personne OneUserById(String id) {
        Optional<Personne> user =  appUserRepository.findById(id);
        return user.get();
    }
    @Override
    public void saveUser(Personne user) {
        appUserRepository.save(user);

    }



}
