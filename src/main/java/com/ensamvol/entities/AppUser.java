package com.ensamvol.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document
@NoArgsConstructor @AllArgsConstructor @Data
public class AppUser {
    @Id
    private String idUtilisateur;
    @Field
    private String Nom;
    @Field
    private String Prenom;
    @Field
    private Date Date_Naissance;
    @Field
    private String Niveau_Etude;
    @Field
    private Boolean DeLEnsam;
    @Field
    private String Universite;
    @Field
    private Boolean DeBureau;
    @Field
    private String Description;
    @Field
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Indexed(unique = true)
    private String username;
    @Field
    private String Password;
    @DBRef
    private List<AppRole> appRoles ;

}
