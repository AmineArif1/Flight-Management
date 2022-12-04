package com.ensamvol.repositories;


import com.ensamvol.entities.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends MongoRepository<AppUser,String> {
    AppUser findByUsername(String username);
}
