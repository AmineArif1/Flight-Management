package com.ensamvol.repositories;

import com.ensamvol.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository<Role,Integer> {
    Role findByRoleName(String roleName);

}
