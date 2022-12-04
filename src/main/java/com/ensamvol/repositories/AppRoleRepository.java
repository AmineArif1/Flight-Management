package com.ensamvol.repositories;

import com.ensamvol.entities.AppRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends MongoRepository<AppRole,String> {
    AppRole findByRoleName(String roleName);
}
