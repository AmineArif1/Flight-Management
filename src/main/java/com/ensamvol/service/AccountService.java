package com.ensamvol.service;





import com.ensamvol.entities.AppRole;
import com.ensamvol.entities.AppUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public interface AccountService {

    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appROle);
    void addRoleToUser(String username,String roleName);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();
    List<AppRole> listRoles();

    void removeUser(String username);
    AppUser OneUserById(String id);
    void saveUser(AppUser user);
    List<AppRole> loadUserRoles(String username);


}

